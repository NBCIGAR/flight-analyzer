package com.eran.flight.analyzer.rest.client.helper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HttpRestClient {

    private HttpClient client;

    private HttpRequest.Builder httpRequestBuilder;

    @Autowired
    public HttpRestClient(ObjectMapper objectMapper) {
        ProxySelector selector = ProxySelector.of(new InetSocketAddress("127.0.0.1", 9000));
        client = HttpClient.newBuilder().proxy(selector).followRedirects(HttpClient.Redirect.ALWAYS).priority(1)
                .version(HttpClient.Version.HTTP_2).build();

        httpRequestBuilder = HttpRequest.newBuilder().header("Content-Type", "application/json")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "7885a77bd3msh95bd0a57280cbecp125b34jsn99db3786b995");
    }

    private static <T> T safeNPEGet(Supplier<T> toGet) {
        try {
            return toGet.get();
        } catch (NullPointerException npe) {
            return null;
        }
    }

    public static <T> HttpRequest.BodyPublisher ofJson(T data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String stringData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        log.debug("Data to be send :: {}", stringData);
        return HttpRequest.BodyPublishers.ofString(stringData);
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    public <T, V> Either<Failure, T> sendPostJsonRequest(URI uri, V data, Class<T> clazz) {
        log.info("calling {} ...", uri);
        try {
            HttpRequest httpRequest = httpRequestBuilder.uri(uri).POST(ofJson(data)).build();
            return sendAndReceive(clazz, httpRequest);
        } catch (JsonProcessingException e) {
            log.error("", e);
            return Either.left(Failure.builder().message(e.getMessage()).build());
        }

    }

    public <T> Either<Failure, T> sendPostFormRequest(URI uri, Map<Object, Object> data, Class<T> clazz) {
        log.info("calling {} ...", uri);
        HttpRequest httpRequest = httpRequestBuilder.uri(uri).POST(ofFormData(data)).build();
        return sendAndReceive(clazz, httpRequest);

    }

    public <T> Either<Failure, T> sendGetRequest(URI uri, Class<T> clazz) {
        HttpRequest httpRequest = httpRequestBuilder.uri(uri).GET().build();
        log.info("calling {} ...", httpRequest.uri());
        return sendAndReceive(clazz, httpRequest);

    }

    private <T> Either<Failure, T> sendAndReceive(Class<T> clazz, HttpRequest httpRequest) {
        try {
            HttpResponse<Either<Failure, T>> response =
                    client.send(httpRequest, JsonBodyHandler.jsonBodyHandler(clazz));
            String simpleName = safeNPEGet(() -> response.body().getClass().getSimpleName());
            if (response.statusCode() == 200) {
                log.info("{} : status code = {}", simpleName, response.statusCode());
                log.info("{} : response body = {}", simpleName, response.body());
                return Either.right(response.body().right());
            } else {
                log.error("{} : status code = {}", simpleName, response.statusCode());
                log.error("{} : response body = {}", simpleName, response.body());
                return Either.left(response.body().left());
            }
        } catch (InterruptedException | IOException e) {
            log.error("Can't send response", e);
            if (Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
            }
            return Either.left(Failure.builder().message(e.getMessage()).build());
        } catch (Exception e) {
            log.error("Exception during http call", e);
            return Either.left(Failure.builder().message(e.getMessage()).build());
        }
    }

}

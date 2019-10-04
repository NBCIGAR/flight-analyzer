package com.eran.flight.analyzer.rest.client.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.function.Function;

import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonBodyHandler<T> implements HttpResponse.BodyHandler<Either<Failure, T>> {
    private final Class<T> type;

    private ObjectMapper objectMapper;

    private JsonBodyHandler(Class<T> type) {
        this.objectMapper = new ObjectMapper();
        this.type = type;
    }

    public static <T> JsonBodyHandler<T> jsonBodyHandler(final Class<T> type) {
        return new JsonBodyHandler<>(type);
    }

    @Override
    public HttpResponse.BodySubscriber<Either<Failure, T>> apply(final HttpResponse.ResponseInfo responseInfo) {
        return HttpResponse.BodySubscribers.mapping(HttpResponse.BodySubscribers.ofByteArray(),
                mapStringJsonToObject());
    }

    private Function<byte[], Either<Failure, T>> mapStringJsonToObject() {
        return byteArray -> {
            try {
                return Either.right(this.objectMapper.readValue(new ByteArrayInputStream(byteArray), this.type));
            } catch (JsonParseException | JsonMappingException e) {
                log.error("Can't parse response", e);
                return Either.left(Failure.builder().build());
            } catch (IOException e) {
                log.error("Can't read response", e);
                return Either.left(Failure.builder().build());
            }
        };
    }

}
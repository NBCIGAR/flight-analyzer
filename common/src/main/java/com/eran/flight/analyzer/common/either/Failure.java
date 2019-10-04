package com.eran.flight.analyzer.common.either;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Failure {

    @Builder.Default
    private Long code = 0L;

    @Builder.Default
    private String message = "";

}

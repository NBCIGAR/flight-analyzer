package com.eran.flight.analyzer.common.either;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FailureCode {

    UNDEFINED(1L), GLOBAL_EXCEPTION_CODE(3L),

    DATA_INTEGRITY_VIOLATION_CODE(2L), OPTIMISTIC_LOCK_EXCEPTION(4L), BS_ID_NOT_FOUND_IN_RESPONSE_CODE(5L),
    NO_RESULT_FOUND_CODE(6L);

    private Long code;

}

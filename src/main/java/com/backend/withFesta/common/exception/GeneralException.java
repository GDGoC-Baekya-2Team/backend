package com.backend.withFesta.common.exception;

import com.backend.withFesta.common.status.ErrorStatus;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{
    private final ErrorStatus errorStatus;

    public GeneralException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}

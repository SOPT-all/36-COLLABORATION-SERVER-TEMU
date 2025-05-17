package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception;

import lombok.Getter;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant.ErrorCode;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}


package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant.ErrorCode;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@JsonPropertyOrder({"success", "code", "message", "timestamp"})
public class BaseErrorResponse {
    private final boolean success;
    private final int code;
    private final String message;
    private final LocalDateTime timestamp;

    public BaseErrorResponse(boolean success, int code, String message, LocalDateTime timestamp) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public BaseErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
        this.success = false;
        this.timestamp = LocalDateTime.now();
    }

    public BaseErrorResponse(ErrorCode errorCode, HttpStatusCode httpStatusCode) {
        this.code = httpStatusCode.value();
        this.message = errorCode.getMessage();
        this.success = false;
        this.timestamp = LocalDateTime.now();
    }
}

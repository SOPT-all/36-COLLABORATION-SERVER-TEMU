package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


public interface ErrorCode {
    int getHttpStatus();
    int getCode();
    String getMessage();
}

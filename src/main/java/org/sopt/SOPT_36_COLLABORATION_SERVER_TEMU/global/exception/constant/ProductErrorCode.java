package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ProductErrorCode implements ErrorCode {
    PRODUCT_NOT_FOUND(200, NOT_FOUND.value(), "존재하지 않는 상품입니다.")
    ;
    private final int code;
    private final int httpStatus;
    private final String message;
}

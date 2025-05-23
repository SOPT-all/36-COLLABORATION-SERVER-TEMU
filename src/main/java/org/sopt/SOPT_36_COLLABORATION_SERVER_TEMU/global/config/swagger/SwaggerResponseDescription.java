package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger;

import lombok.Getter;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant.ErrorCode;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant.GlobalErrorCode.*;
import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant.ProductErrorCode.PRODUCT_NOT_FOUND;

@Getter
public enum SwaggerResponseDescription {
    PRODUCT_DETAIL(new LinkedHashSet<>(Set.of(
            PRODUCT_NOT_FOUND
    ))),
    PRODUCT_REVIEW(new LinkedHashSet<>(Set.of(
            PRODUCT_NOT_FOUND
    )))
    ;
    private final Set<ErrorCode> errorCodeList;
    SwaggerResponseDescription(Set<ErrorCode> errorCodeList) {
        // 공통 에러
        errorCodeList.addAll(new LinkedHashSet<>(Set.of(
                ILLEGAL_ARGUMENT,
                API_NOT_FOUND,
                METHOD_NOT_ALLOWED,
                INTERNAL_SERVER_ERROR,
                UNAUTHORIZED,
                FORBIDDEN
        )));

        this.errorCodeList = errorCodeList;
    }
}

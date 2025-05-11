package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger;

import lombok.Getter;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.ErrorCode;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.ErrorCode.*;

@Getter
public enum SwaggerResponseDescription {
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

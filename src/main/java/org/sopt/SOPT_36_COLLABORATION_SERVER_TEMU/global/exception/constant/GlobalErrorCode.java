package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.constant;

import io.swagger.v3.oas.models.examples.Example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.response.BaseErrorResponse;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@AllArgsConstructor
@Getter
public enum GlobalErrorCode implements ErrorCode {
    ILLEGAL_ARGUMENT(100, BAD_REQUEST.value(), "잘못된 요청값입니다."),
    API_NOT_FOUND(101,HttpStatus.NOT_FOUND.value(), "존재하지 않는 API 입니다."),
    METHOD_NOT_ALLOWED(102, HttpStatus.METHOD_NOT_ALLOWED.value(), "유효하지 않은 Http 메서드입니다."),
    UNAUTHORIZED(103,HttpStatus.UNAUTHORIZED.value(),"인증 자격이 없습니다."),
    FORBIDDEN(104,HttpStatus.FORBIDDEN.value(), "권한이 없습니다."),
    INTERNAL_SERVER_ERROR(105, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다.");
    private final int code;
    private final int httpStatus;
    private final String message;

}

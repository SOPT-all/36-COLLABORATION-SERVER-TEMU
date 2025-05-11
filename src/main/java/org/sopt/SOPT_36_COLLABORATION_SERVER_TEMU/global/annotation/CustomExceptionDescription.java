package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.annotation;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger.SwaggerResponseDescription;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomExceptionDescription {

    SwaggerResponseDescription value();
}

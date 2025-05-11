package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger;

import io.swagger.v3.oas.models.examples.Example;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExampleHolder {

    private Example holder;
    private String name;
    private int code;
}

package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "SOPT 36기 합동 세미나 데스크탑 웹 2팀 TEMU",
                description = "Springdoc을 이용한 Swagger API 문서입니다.",
                version = "1.0"
        )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components());
    }
}

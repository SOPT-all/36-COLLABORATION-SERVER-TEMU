package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final String localAddress = "localhost"; // 로컬 테스트용 IP
    private final String frontEndPort = "5173"; // React 앱이 실행되는 포트
    private final String frondEndOrigin = "https://36-collaboration-web-temu.vercel.app";


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedOrigins(frondEndOrigin,
                        "http://" + this.localAddress + ":" + this.frontEndPort);
    }

}

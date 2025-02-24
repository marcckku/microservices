package com.example.apigateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@ConfigurationProperties(prefix = "spring.cloud.gateway")
@Getter
@Setter
@Component("applicationConfig")
public final class ApplicationConfig {

    private List<Routes> routes;

    @Getter
    @Setter
    public static class Routes {
        private String id;
        private String uri;
        private List<String> predicates;
    }

}

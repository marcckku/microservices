package com.example.apigateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// lo si puo' anche scriverlo sul yaml file
@Configuration
public class GatewayConfig {

    @Autowired
    private  AuthenticationFilter filter;

    @Autowired
    @Qualifier("applicationConfig")
    private ApplicationConfig applicationConfig;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return routesBuilder(builder);
    }




    //return builder.routes()
    //    .route("user-service", r -> r.path("/user-service/**").filters(f -> f.filter(filter)).uri("lb://user-service"))
    //    .route("order-service", r -> r.path("/order-service/**").filters(f -> f.filter(filter)).uri("lb://order-service"))
    //    .build();
    //
    /**
     * I build the association between the api of each running web service
     * and the gateway api.
     *
     * It takes from the paths declared by ApplicationConfig and associates
     * them in the URL path of the calls to the Api Gateway.
     * Call User Web Service Url:
     *                      domain                   id          api web service
     *                  [http://localhost:8080] [/user-service] [api/users/1]
     *                  http://192.168.1.189:8080/user-service/api/users/1
     *
     * @param builder
     * @return RouteLocator
     */
    public RouteLocator routesBuilder(RouteLocatorBuilder builder) {
        List<ApplicationConfig.Routes> thisRoutes = applicationConfig.getRoutes();
        ApplicationConfig.Routes r1 = thisRoutes.get(0);//each route has a predicate
        ApplicationConfig.Routes r2 = thisRoutes.get(1);
        return builder.routes()
                .route(r1.getId(), r -> r.path(r1.getPredicates().get(0).replace("Path=", "")).uri(r1.getUri()))
                .route(r2.getId(), r -> r.path(r2.getPredicates().get(0).replace("Path=", "")).uri(r2.getUri()))
                .build();
    }

}
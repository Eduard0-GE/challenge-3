package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {
    @Bean
    protected RouteLocator routes(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(r ->  r.path("/ms-employees/**").uri("lb://ms-employees"))
                .route(r -> r.path("/ms-voting/**").uri("lb://ms-voting"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}

package me.salahbkd.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    // YOU CAN CONFIGURE GATEWAY ROUTES WITH: RouteLocater
    /*@Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route(route -> route.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();
    }*/

    @Bean // I'AM TELLING SPRING CLOUD GATEWAY I DONT KNOW THE ROUTES OF MICROSERICES, EACH TIME YOU GET A
    // REQUEST SCAN THE URI FOR THE NAME OF THE MICROSERVICE THEN GIVE ME THE RESULTS
    DiscoveryClientRouteDefinitionLocator definitionLocator(
            ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, properties);
    }

}

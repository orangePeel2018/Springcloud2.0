package com.fys.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route",r->r.path("/guonei").uri("https://news.baidu.com/"))
                .route("path_route2",r->r.path("/mil").uri("https://news.baidu.com/"))
                .route("path_route3",r->r.path("/finance").uri("https://news.baidu.com/"))
                .build();
    }
}

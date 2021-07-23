package com.yu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过java代码中注入RouteLocator的Bean实现路由
 */
@Configuration
public class GateWayConfig
{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        routes.route("path_route",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }

}

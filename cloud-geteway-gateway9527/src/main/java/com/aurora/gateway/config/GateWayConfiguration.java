package com.aurora.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbsilent
 * @date 2021年06月11日 12:00 上午
 */
@Configuration
public class GateWayConfiguration {

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    RouteLocatorBuilder.Builder routes = builder.routes();
    routes
        .route("circuitbreaker_route", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
        .build();
    return routes.build();
    //        return builder.routes()
    //                .route("circuitbreaker_route", r -> r.path("/consumingServiceEndpoint")
    //                        .filters(f -> f.circuitBreaker((c) ->
    // c.name("myCircuitBreaker").fallbackUri("forward:/inCaseOfFailureUseThis"))
    //                                .rewritePath("/consumingServiceEndpoint",
    // "/backingServiceEndpoint")).uri("lb://backing-service:8088")
    //                        .build();
  }
}

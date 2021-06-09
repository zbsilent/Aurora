package com.aurora.springcloud.consul.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author zbsilent
 * @date 2021年06月09日 8:16 下午
 */
@Configuration
@LoadBalancerClient(value = "consul-provider")
public class ApplicationContextConfiguration {




    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}

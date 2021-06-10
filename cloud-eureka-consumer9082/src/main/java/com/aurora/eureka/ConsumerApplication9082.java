package com.aurora.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbsilent
 * @date 2021年06月10日 11:35 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class ConsumerApplication9082 {

  public static void main(String[] args) {
    //
    SpringApplication.run(ConsumerApplication9082.class, args);
  }
}

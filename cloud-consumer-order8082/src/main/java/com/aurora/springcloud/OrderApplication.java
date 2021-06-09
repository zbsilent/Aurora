package com.aurora.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zbsilent
 * @date 2021年06月09日 5:07 上午
 */
@SpringBootApplication
public class OrderApplication {
  public static void main(String[] args) {
    //
      SpringApplication.run(OrderApplication.class,args);
  }
//
//  @Bean
//  public RestTemplate restTemplate(){
//      return new RestTemplate();
//  }
}

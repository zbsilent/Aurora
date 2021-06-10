package com.aurora.summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zbsilent
 * @date 2021年06月11日 2:32 上午
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientApplication {

  public static void main(String[] args) {
    //
      SpringApplication.run(ClientApplication.class,args);
  }
}

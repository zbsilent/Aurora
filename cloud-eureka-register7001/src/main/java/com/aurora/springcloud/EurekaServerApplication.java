package com.aurora.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zbsilent
 * @date 2021年06月09日 11:44 上午
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  public static void main(String[] args) {
    //
    SpringApplication.run(EurekaServerApplication.class, args);
  }
}

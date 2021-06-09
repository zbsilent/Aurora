package com.aurora.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zbsilent
 * @date 2021年06月09日 12:40 下午
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegisterApplication {

  public static void main(String[] args) {
    //
      SpringApplication.run(EurekaRegisterApplication.class,args);
  }
}

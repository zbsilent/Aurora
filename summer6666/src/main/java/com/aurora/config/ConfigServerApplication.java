package com.aurora.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http://127.0.0.1:3344/main/config-dev.yml
 * @author zbsilent
 * @date 2021年06月11日 1:47 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

  public static void main(String[] args) {
    //
      SpringApplication.run(ConfigServerApplication.class,args);
  }
}

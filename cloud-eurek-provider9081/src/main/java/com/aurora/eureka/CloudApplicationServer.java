package com.aurora.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zbsilent
 * @date 2021年06月10日 10:52 上午
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudApplicationServer {

  public static void main(String[] args) {

    SpringApplication.run(CloudApplicationServer.class, args);

  }
}

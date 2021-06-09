package com.aurora.springcloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbsilent
 * @date 2021年06月09日 8:14 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CsConsumerApplication {

  public static void main(String[] args) {
      SpringApplication.run(CsConsumerApplication.class,args);
  }
}

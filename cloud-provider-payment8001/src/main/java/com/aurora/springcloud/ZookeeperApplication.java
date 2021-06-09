package com.aurora.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbsilent
 * @date 2021年06月09日 3:46 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperApplication {

  public static void main(String[] args) {
      SpringApplication.run(ZookeeperApplication.class,args);
  }
}

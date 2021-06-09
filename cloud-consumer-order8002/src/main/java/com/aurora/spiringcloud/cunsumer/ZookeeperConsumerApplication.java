package com.aurora.spiringcloud.cunsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbsilent
 * @date 2021年06月09日 6:20 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperConsumerApplication.class,args);
  }
}

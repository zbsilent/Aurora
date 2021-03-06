package com.aurora.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zbsilent
 * @date 2021年06月09日 1:22 上午
 */
@SpringBootApplication
@MapperScan("com.aurora.springcloud.mapper")
@EnableTransactionManagement
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentApplication {

  public static void main(String[] args) {
      SpringApplication.run(PaymentApplication.class,args);

  }

}

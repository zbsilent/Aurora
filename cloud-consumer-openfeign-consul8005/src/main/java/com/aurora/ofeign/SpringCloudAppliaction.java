package com.aurora.ofeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbsilent
 * @date 2021年06月09日 10:43 下午
 */
@SpringBootApplication
@EnableFeignClients
public class SpringCloudAppliaction {

  public static void main(String[] args) {
    //
    SpringApplication.run(SpringCloudAppliaction.class, args);
  }
}

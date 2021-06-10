package com.aurora.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zbsilent
 * @date 2021年06月10日 6:12 下午
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Apps {
  public static void main(String[] args) {
    SpringApplication.run(Apps.class, args);
  }
}

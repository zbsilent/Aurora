package com.aurora.eureka.controller;

import com.aurora.springcloud.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
// @PropertySource(value="classpath:appliaction-eureka.yml")
public class ProviderController {

  @Value("${server.port}")
  private String serverPort;

  @Autowired private DiscoveryClient discoveryClient;

  @GetMapping("/provider/any")
  public CommonResult doAnython() throws Exception {

    log.info("=> 进入服务提供者");
    List<String> services = discoveryClient.getServices();
    if (services.isEmpty()) {
      log.info("离开服务提供者 <=");
      throw new Exception("没有获取到服务信息");
    }
    services.forEach((service) -> log.info(service + "\t"));
    log.info("离开服务提供者 <=");
    return new CommonResult(200, "服务端口：" + serverPort + "得到数据", services);
  }
}

package com.aurora.springcloud.consul.controller;

import com.aurora.springcloud.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zbsilent
 * @date 2021年06月09日 7:58 下午
 */
@RestController
@Slf4j
public class CsProviderController {

  @Value("${server.port}")
  private String serverPort;

  @Autowired DiscoveryClient client;

  @GetMapping("/consul/check")
  public Object discovery() throws Exception {
    List<String> services = client.getServices();
    services.forEach((service)-> log.info(service+",serial:"+UUID.randomUUID().toString()));
    return services;
  }
  @GetMapping("/consul/timeout")
  public String paymentFeignTimeOut(){
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return serverPort;
  }
}

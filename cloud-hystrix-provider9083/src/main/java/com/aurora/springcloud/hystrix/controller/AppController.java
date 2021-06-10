package com.aurora.springcloud.hystrix.controller;

import com.aurora.springcloud.hystrix.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbsilent
 * @date 2021年06月10日 12:14 下午
 */
@RestController
@Slf4j
public class AppController {

  @Autowired AppService appService;

  @Value("${server.port}")
  private String port;

  @GetMapping("/provider/hystrix/success/{id}")
  public String success(@PathVariable("id") Integer id) {
    log.info("访问成功");
    return appService.success(id);
  }

  @GetMapping("/provider/hystrix/error/{id}")
  public String error(@PathVariable("id") Integer id) {
    log.info("访问失败");
    return appService.error(id);
  }

  @GetMapping("/provider/hystrix/timer/{timer}")
  public String errorThan(@PathVariable("timer") Integer timer) {
    log.info("访问失败");
    return appService.errorThan(timer);
  }

  @GetMapping("/provider/hystrix/dlq/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
    log.info("---->进入service");
    return appService.paymentCircuitBreaker(id);
  }
}

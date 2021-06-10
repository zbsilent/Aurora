package com.aurora.eureka.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * fallbackFactory = FabllBackFactory.class
 *
 * @author zbsilent
 * @date 2021年06月10日 12:43 下午
 */
@Component
@FeignClient(name = "PROVIDER-HYSTRIX")
public interface ConsumerHystrixService {

  @GetMapping("/provider/hystrix/success/{id}")
  public String success(@PathVariable("id") Integer id);

  @GetMapping("/provider/hystrix/error/{id}")
  public String error(@PathVariable("id") Integer id);

  @GetMapping("/provider/hystrix/timer/{timer}")
  public String errorThan(@PathVariable("timer") Integer timer);
}

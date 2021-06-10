package com.aurora.eureka.controller;

import com.aurora.eureka.service.ConsumerHystrixService;
import com.aurora.eureka.service.ConsumerService;
import com.aurora.springcloud.common.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbsilent
 * @date 2021年06月10日 11:39 上午
 */
@RestController
public class ConsumerController {

  @Autowired private ConsumerService consumerService;

  @Autowired private ConsumerHystrixService consumerHystrixService;

  @GetMapping("/consumer/provider/any")
  public CommonResult doAny() {

    CommonResult commonResult = null;
    try {
      commonResult = consumerService.doAnython();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return commonResult;
  }

  @GetMapping("/consumer/hystrix/success/{id}")
  public String success(@PathVariable("id") Integer id) {
    return consumerHystrixService.success(id);
  }

  @GetMapping("/consumer/hystrix/timer/{timer}")
  public String errorThan(@PathVariable("timer") Integer timer) {
    return consumerHystrixService.errorThan(timer);
  }

  @GetMapping("/consumer/hystrix/error/{id}")
  @HystrixCommand(
      fallbackMethod = "errorHandle",
      commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"),
        @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
      })
  public String error(@PathVariable("id") Integer id) {
    return consumerHystrixService.error(id);
  }

  public String errorHandle(Integer id) {
    return "线程池，线程"
        + Thread.currentThread().getName()
        + "- 发生服务降级，请求参数为"
        + id
        + " \t "
        + "，🤮降级了，系统繁忙稍后再试CONTROLLER";
  }

  public String globalErrorHandle() {
    return "线程池，线程" + Thread.currentThread().getName() + "-，🤮降级了，进入全局了";
  }
}

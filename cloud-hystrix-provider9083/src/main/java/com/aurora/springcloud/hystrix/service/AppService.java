package com.aurora.springcloud.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zbsilent
 * @date 2021年06月10日 12:11 下午
 */
@Service
public class AppService {
  /**
   * ok方法
   *
   * @param id
   * @return
   */
  public String success(Integer id) {
    return "线程池，线程 ：" + Thread.currentThread().getName() + "，调用成功，请求参数为" + id + "\t" + "，😄正常访问";
  }

  /**
   * 异常返回 超过3秒就服务降级
   *
   * @param id
   * @return
   */
  @HystrixCommand(
      fallbackMethod = "errorHandle",
      commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
        @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
      })
  public String error(Integer id) {
    int timer = 5;
    try {
      TimeUnit.SECONDS.sleep(timer);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池，线程"
        + Thread.currentThread().getName()
        + "- 发生异常，请求参数为"
        + id
        + " \t "
        + "，😭访问异常耗时"
        + timer
        + "(秒)";
  }

  public String errorThan(Integer timer) {

    int timersleep = 6;
    try {
      TimeUnit.SECONDS.sleep(timersleep);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池，线程"
        + Thread.currentThread().getName()
        + "- 发生异常，请求参数为"
        + timersleep
        + " \t "
        + "，😭访问异常耗时"
        + timersleep
        + "(秒)";
  }

  public String errorHandle(Integer id) {
    return "线程池，线程"
        + Thread.currentThread().getName()
        + "- 发生服务降级，请求参数为"
        + id
        + " \t "
        + "，🤮降级了，系统繁忙稍后再试";
  }

  /***服务熔断*/
  @HystrixCommand(
      fallbackMethod = "paymentCircuitBreaker_fallback",
      commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), // 请求次数
        @HystrixProperty(
            name = "circuitBreaker.sleepWindowInMilliseconds",
            value = "10000"), // 时间窗口
        @HystrixProperty(
            name = "circuitBreaker.errorThresholdPercentage",
            value = "60") // 失败率到多少后跳闸
      })
  public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
    if (id < 0) {
      throw new RuntimeException("===> id 不能为 负数");
    }

    String serialNumber = IdUtil.simpleUUID();
    return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
  }

  public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
    return "id 不能负数，请稍后再试，id ：" + id;
  }
}

package com.aurora.eureka.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zbsilent
 * @date 2021年06月10日 2:02 下午
 */
@Component
public class FabllBackFactory implements FallbackFactory<ConsumerHystrixService> {

  @Override
  public ConsumerHystrixService create(Throwable cause) {
    return new ConsumerHystrixService() {
      @Override
      public String success(Integer id) {
        return null;
      }

      @Override
      public String error(Integer id) {
        return "超时设置异常返回";
      }

      @Override
      public String errorThan(Integer timer) {
        return "超时设置异常返回";
      }
    };
  }
}

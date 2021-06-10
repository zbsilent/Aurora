package com.aurora.eureka.service;

import com.aurora.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("PROVIDER-SINGLE")
public interface ConsumerService {

  @GetMapping("/provider/any")
  public CommonResult doAnython() throws Exception;
}

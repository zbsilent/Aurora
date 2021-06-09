package com.aurora.springcloud.controller;

import com.aurora.springcloud.common.CommonResult;
import com.aurora.springcloud.payment.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zbsilent
 * @date 2021年06月09日 5:26 上午
 */
@RestController
@Slf4j
public class OrderController {

  public static final String PATH_URL = "http://127.0.0.1:8081";

  @Autowired private RestTemplate restTemplate;

  @GetMapping("/order/{id}")
  public CommonResult<?> get(@PathVariable("id") long id) throws Exception {
    CommonResult<?> commonResult =
        restTemplate.getForObject(PATH_URL + "/payment/"+id, CommonResult.class);
    if (commonResult != null && commonResult.getCode() == 200) {
      return commonResult;
    }
    throw new Exception("失败");
  }
}

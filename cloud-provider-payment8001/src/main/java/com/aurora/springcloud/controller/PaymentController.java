package com.aurora.springcloud.controller;

import com.aurora.springcloud.common.CommonResult;
import com.aurora.springcloud.payment.Payment;
import com.aurora.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zbsilent
 * @date 2021年06月09日 4:07 上午
 */
@RestController
@Slf4j
public class PaymentController {

  @Autowired private PaymentService paymentService;


  @Autowired
  DiscoveryClient discoveryClient;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping("/payment")
  public CommonResult<?> save(@RequestBody Payment payment) {
    log.debug("***进入保存***");
    int result = paymentService.save(payment);
    if (result > 0) {
      return new CommonResult<Integer>(200, serverPort+"，插入成功", result);
    }
    return new CommonResult<Integer>(404, "掺入失败", result);
  }

  @DeleteMapping("/payment/{id}")
  public void delete(@PathVariable("id") long id) {
    paymentService.deleteByid(id);
  }

  @PutMapping("/payment")
  public void update(@RequestBody Payment payment) {
    paymentService.update(payment);
  }

  @GetMapping("/payment/{id}")
  public CommonResult<?> queryById(@PathVariable("id") long id) throws Exception {
    log.debug("==> 查询开始,参数 ："+ id);
    Payment payment = paymentService.queryById(id);
    if (payment != null) {
      return new CommonResult<>(200, serverPort+"，查询成功", payment);
    }
    throw new Exception("没有查询到数据");
    //return new CommonResult<>(404, "error", new Exception("null").getMessage());
  }
  @GetMapping("/payment/discovery")
  public Object discovery(){
    List<String> services = discoveryClient.getServices();
    services.forEach((service)->log.debug(service));
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    instances.forEach((instance)->log.debug(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()));
    return this.discoveryClient;
  }
}

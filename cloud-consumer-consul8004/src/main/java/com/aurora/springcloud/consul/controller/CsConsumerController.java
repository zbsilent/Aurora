package com.aurora.springcloud.consul.controller;

import com.aurora.springcloud.consul.config.loadbalancer.CustomerLoadBanlancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author zbsilent
 * @date 2021年06月09日 8:17 下午
 */
@RestController
@Slf4j
public class CsConsumerController {

    private static final String URI ="http://consul-provider";

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    CustomerLoadBanlancer customerLoadBanlancer;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/consul/check")
    public String check() throws Exception{
        List<String> services = discoveryClient.getServices();
        log.info("=> 执行接口调用");
        String forObject = restTemplate.getForObject(URI + "/consul/check", String.class);
        log.info("=> 接口返回数据："+ forObject);
        return forObject;

    }
    @GetMapping("/consumer/consul/get")
    public String getPayMent() throws Exception{
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-provider");
        if(instances.isEmpty()){
            throw new Exception("检查为空");
        }
        ServiceInstance instances1 = customerLoadBanlancer.instances(instances);
        java.net.URI uri = instances1.getUri();

        return restTemplate.getForObject(uri+ "/consul/check",String.class);

    }
}

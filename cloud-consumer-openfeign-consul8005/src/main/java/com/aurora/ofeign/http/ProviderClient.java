package com.aurora.ofeign.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Reno
 */
@Component
@FeignClient(name = "consul-provider")
public interface ProviderClient
{

    @GetMapping("/consul/check")
    public Object discovery() throws Exception ;


    @GetMapping("/consul/timeout")
    public String paymentFeignTimeOut();
}

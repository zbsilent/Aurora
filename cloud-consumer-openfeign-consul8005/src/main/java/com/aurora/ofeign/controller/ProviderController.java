package com.aurora.ofeign.controller;

import com.aurora.ofeign.http.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

/**
 * @author zbsilent
 * @date 2021年06月09日 10:53 下午
 */
@RestController
public class ProviderController {

    @Autowired
    ProviderClient providerClient;

    @GetMapping("/feign/get")
    public Object getInfo() throws Exception {
        return providerClient.discovery();
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut(){
        return providerClient.paymentFeignTimeOut();
    }
}

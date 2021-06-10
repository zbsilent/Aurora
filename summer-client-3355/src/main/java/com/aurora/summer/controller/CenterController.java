package com.aurora.summer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbsilent
 * @date 2021年06月11日 3:03 上午
 */
@RestController
@RefreshScope
public class CenterController {

    //curl -X POST "http://localhost:3355/actuator/refresh"
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}

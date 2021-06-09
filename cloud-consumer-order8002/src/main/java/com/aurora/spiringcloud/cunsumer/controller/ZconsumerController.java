package com.aurora.spiringcloud.cunsumer.controller;

import com.aurora.springcloud.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zbsilent
 * @date 2021年06月09日 6:21 下午
 */
@RestController
public class ZconsumerController {

    public static final String PATH_URL = "http://cloud-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/check/{id}")
    public CommonResult check(@PathVariable("id") int id) throws Exception{
        if(id>=3){
            return new CommonResult(200,"成功","success");
        }
        throw new Exception("成功");
    }


    @GetMapping("/consumer/payment/{id}")
    public CommonResult<?> get(@PathVariable("id") long id) throws Exception {
        CommonResult<?> commonResult =
                restTemplate.getForObject(PATH_URL + "/payment/"+id, CommonResult.class);
        if (commonResult != null && commonResult.getCode() == 200) {
            return commonResult;
        }
        throw new Exception("失败");
    }
}

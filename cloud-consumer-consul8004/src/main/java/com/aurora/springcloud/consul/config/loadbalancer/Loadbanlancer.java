package com.aurora.springcloud.consul.config.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface Loadbanlancer {

    /**
     * 容器加载即获取机器总数
     * @see org.springframework.cloud.client.discovery.DiscoveryClient#getInstances
     * @param serviceInstances  serviceInstances
     * @return ServiceInstance
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}

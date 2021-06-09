package com.aurora.springcloud.consul.config.loadbalancer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zbsilent
 * @date 2021年06月09日 10:00 下午
 */
@Component
@Slf4j
public class CustomerLoadBanlancer implements Loadbanlancer {

  private final AtomicInteger position = new AtomicInteger();
  /** 自旋锁取余数字 */
  public final int getAndIncrement() {
    int current;
    int next;
    do {
      current = this.position.get();
      next = current >= Integer.MAX_VALUE ? 0 : current + 1;
    } while (!this.position.compareAndSet(current, next));
    log.info("==>第几次访问次数 next:" + next);
    return next;
  }

  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

    int pos = this.getAndIncrement();

    return serviceInstances.get(pos % serviceInstances.size());
  }
}

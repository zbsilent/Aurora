package com.aurora.springcloud.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author zbsilent
 * @date 2021年06月10日 12:10 下午
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class MainApps {
  public static void main(String[] args) {
    //
    SpringApplication.run(MainApps.class, args);
  }

  @Bean
  public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean servletRegistrationBean =
        new ServletRegistrationBean(hystrixMetricsStreamServlet);
    servletRegistrationBean.setLoadOnStartup(1);
    servletRegistrationBean.addUrlMappings("/hystrix.stream");
    servletRegistrationBean.setName("HystrixMetricsStreamServlet");
    return servletRegistrationBean;
  }
}

package com.fys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //配置eureka客户端类
@EnableDiscoveryClient
public class PaymentMain8001 {
     public static void main(String[] args) {
           SpringApplication.run(PaymentMain8001.class, args);
      }
}

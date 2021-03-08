package com.fys.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;


public interface LoadBalaner {

    ServiceInstance instance(List<ServiceInstance> instances);
}

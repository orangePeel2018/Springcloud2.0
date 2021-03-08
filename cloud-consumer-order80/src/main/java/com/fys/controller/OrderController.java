package com.fys.controller;


import com.fys.entities.CommonResult;
import com.fys.entities.Payment;
import com.fys.lb.LoadBalaner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

    //设置支付服务模块的url
    public static final String PAYENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    //引入自己写的LB
    @Resource
    private LoadBalaner loadBalaner;

    //引入discovery
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 通过顾客端调用支付端创建订单
     * @param payment 实例对象
     * @return 实例对象
     */
    @GetMapping(value ="/consumer/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYENT_URL+"/payment/create",payment,CommonResult.class);
    }

    /**
     *   通过顾客端调用支付端查找订单
     * @param id 订单标识
     * @return 实例对象
     */
    @GetMapping("/consumer/selectOne/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYENT_URL+"/payment/selectOne/"+id,CommonResult.class);
    }

    //测试自己写的轮询法则
    @GetMapping("/consumer/lb")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() ==0){
            return null;
        }
        ServiceInstance instance = loadBalaner.instance(instances);
        URI uri = instance.getUri();
        System.out.println(uri+"/payment/lb");
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}





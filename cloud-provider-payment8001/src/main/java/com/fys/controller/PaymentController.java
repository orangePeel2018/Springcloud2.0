package com.fys.controller;

import com.fys.entities.CommonResult;
import com.fys.entities.Payment;
import com.fys.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
       Payment insert =  paymentService.insert(payment);
       log.info("*******插入结果："+insert);
       if(insert==null){
           return new CommonResult(404,"insert error,serverPort:"+servicePort ,null);
       }else{
           return new CommonResult(200,"insert success,serverPort:"+servicePort  ,insert);
       }
    }


    @GetMapping(value = "/payment/selectOne/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("*******查询结果：" + payment);
        if (payment == null) {
            return new CommonResult(404, "select error,serverPort:" + servicePort, null);
        } else {
            return new CommonResult(200, "select success,serverPort:" + servicePort, payment);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(service->{
            System.out.println("----------service:"+service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance->{
            System.out.println(instance.getHost()+"---"+instance.getPort()+"----"+instance.getUri());
        });
        return discoveryClient;
    }


    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return servicePort;
    }

    @GetMapping("/payment/timeOut")
    public String paymentTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }
}

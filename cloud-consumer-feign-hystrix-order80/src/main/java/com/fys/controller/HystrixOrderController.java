package com.fys.controller;

import com.fys.serivce.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "paymentInfo_ERROR_Handler")
public class HystrixOrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping(value = "/consumer/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return  paymentHystrixService.getPaymentInfo_OK(id);
    }


    @GetMapping(value = "/consumer/timeout/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentInfo_ErrorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentInfo_Error(@PathVariable("id") Integer id){
        return  paymentHystrixService.getPaymentInfo_Error(id);
    }

    public String paymentInfo_ERROR_Handler(){
        return "80____paymentInfo_ERROR_Handler___异常返回";
    }

    public String getPaymentInfo_ErrorHandler(@PathVariable("id") Integer id){
        return "80____paymentInfo_ERROR_Handler2___异常返回";
    }
}

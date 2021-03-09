package com.fys.controller;

import com.fys.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentHystrixService paymentService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentInfo_OK(@PathVariable("id") Integer id){
       return paymentService.getPaymentInfo_OK(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String getPaymentInfo_Error(@PathVariable("id") Integer id){
        return paymentService.getPaymentInfo_Error(id);
    }

    @GetMapping(value = "/payment/hystrix/CircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return  paymentService.paymentCircuitBreaker(id);
    }
}


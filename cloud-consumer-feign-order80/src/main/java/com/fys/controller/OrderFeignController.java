package com.fys.controller;


import com.fys.entities.CommonResult;
import com.fys.entities.Payment;
import com.fys.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/selectOne/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("/consumer/timeOut")
    public String PaymentTimeOut(){
        return paymentFeignService.paymentTimeOut();
    }
}

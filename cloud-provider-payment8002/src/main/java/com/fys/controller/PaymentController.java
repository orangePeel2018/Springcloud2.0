package com.fys.controller;


import com.fys.entities.CommonResult;
import com.fys.entities.Payment;
import com.fys.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
       Payment insert =  paymentService.insert(payment);
       log.info("*******插入结果："+insert);
       if(insert==null){
           return new CommonResult(404,"insert error,serverPort:"+servicePort ,null);
       }else{
           return new CommonResult(200,"insert success,serverPort:"+servicePort ,insert);
       }
    }


    @GetMapping(value = "/payment/selectOne/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        Payment payment =  paymentService.queryById(id);
        log.info("*******查询结果："+payment);
        if(payment==null){
            return new CommonResult(404,"select error,serverPort:"+servicePort,null);
        }else{
            return new CommonResult(200,"select success,serverPort:"+servicePort,payment);
        }
    }
}

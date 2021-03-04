package com.fys.controller;

import com.fys.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderConsulController {

    private static final String PAYENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consulConsumer/selectOne/{id}")
    public CommonResult selectOne(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYENT_URL+"/payment/selectOne/"+id,CommonResult.class);
    }
}

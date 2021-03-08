package com.fys.service;


import com.fys.entities.CommonResult;
import com.fys.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("payment/selectOne/{id}")
    CommonResult<Payment> selectOne(@PathVariable("id") Long id);

    @GetMapping("payment/timeOut")
    String paymentTimeOut();

}

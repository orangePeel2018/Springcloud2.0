package com.fys.service;



public interface PaymentHystrixService {

    String getPaymentInfo_OK(Integer id);
    String getPaymentInfo_Error(Integer id);
    String paymentCircuitBreaker(Integer id);
}

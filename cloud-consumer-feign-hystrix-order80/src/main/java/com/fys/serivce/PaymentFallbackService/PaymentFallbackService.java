package com.fys.serivce.PaymentFallbackService;

import com.fys.serivce.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String getPaymentInfo_OK(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String getPaymentInfo_Error(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}

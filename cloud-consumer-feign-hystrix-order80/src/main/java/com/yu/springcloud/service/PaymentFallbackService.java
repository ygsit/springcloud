package com.yu.springcloud.service;

import org.springframework.stereotype.Component;

//用于处理宕机的类一定要继承feign的service接口
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务宕机-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬);";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务宕机-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)\"";
    }
}

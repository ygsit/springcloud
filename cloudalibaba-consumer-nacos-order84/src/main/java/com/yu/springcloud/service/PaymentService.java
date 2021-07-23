package com.yu.springcloud.service;

import com.yu.springcloud.entity.CommonResult;
import com.yu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class) //配置服务级别的降级
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
package com.yu.springcloud.service;

import com.yu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 业务逻辑接口+@FeignClient配置调用provider服务
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/selectById/{id}")
    CommonResult selectById(@PathVariable("id") Long id);

    @GetMapping("/payment/getTimeOut")
    String getTimeOut();
}

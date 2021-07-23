package com.yu.springcloud.controller;

import com.yu.springcloud.entity.CommonResult;
import com.yu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/get/{id}")
    public CommonResult selectById(@PathVariable Long id) {
        return paymentFeignService.selectById(id);
    }

    @GetMapping("/consumer/payment/getTimeOut")
    public String getTimeOut() {
        return paymentFeignService.getTimeOut();
    }
}

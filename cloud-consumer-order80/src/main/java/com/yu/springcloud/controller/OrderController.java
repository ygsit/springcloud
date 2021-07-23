package com.yu.springcloud.controller;

import com.yu.springcloud.entity.CommonResult;
import com.yu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate:
 * postForEntity：返回的是ResponseEntity对象，可以获取请求的响应头、响应体、响应状态码等
 * postForObject：可以直接放回需要的对象
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //访问地址对外提供的服务名

    @GetMapping("/consumer/get/{id}")
    public CommonResult selectById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/selectById/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/insert")
    public CommonResult insert(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }

    @GetMapping("/consumer/getEntity/{id}")
    public CommonResult selectByIdForEntity(@PathVariable Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/selectById/" + id, CommonResult.class);
        log.info("返回entity信息：" + entity.getStatusCode() + "\t" + entity.getHeaders());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "调用服务异常");
        }
    }

    @GetMapping("/consumer/insertEntity")
    public CommonResult insertForEntity(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "调用服务异常");
        }
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/", String.class);
        return result;
    }

}

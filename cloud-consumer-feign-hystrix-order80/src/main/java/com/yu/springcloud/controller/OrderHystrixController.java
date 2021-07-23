package com.yu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//设置默认兜底方法，当HystrixCommand注解未设置fallbackMethod且出现异常或超时时，会自动进入默认兜底方法；若设置了则会进入设置的fallbackMethod
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand  //默认全局兜底方法
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        //int a = 10/0;
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*******result:" + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle"
            , commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")}
    )
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int a = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("*******result:" + result);
        return result;
    }
    //兜底方法
    public String paymentInfo_TimeOutHandle(@PathVariable("id") Integer id) {
        return "进入了兜底方法，我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    //全局兜底方法
    public String payment_Global_FallbackMethod() {
        return "进入全局兜底方法，Global异常处理信息，请稍后再试,(┬＿┬);";
    }

}

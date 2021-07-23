package com.yu.springcloud.controller;

import com.yu.springcloud.entity.CommonResult;
import com.yu.springcloud.entity.Payment;
import com.yu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author yu
 * @since 2020-11-15 17:26:04
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现Discovery
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
     *
     * @return
     */
    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***** service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/selectById/{id}")
    public CommonResult selectById(@PathVariable Long id) {
        Payment payment = paymentService.selectById(id);
        log.info("查询结果：" + payment);
        if (payment == null) {
            return new CommonResult(444, "没有对应记录，查询Id：" + id);
        } else {
            return new CommonResult(200, "查询成功, serverPort = " + serverPort, payment);
        }
    }

    @PostMapping("/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        try {
            int result = paymentService.insert(payment);
            log.info("查询结果：" + result);
            if (result > 0) {
                return new CommonResult(200, "插入数据库成功", result);
            } else {
                return new CommonResult(444, "插入数据库失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(444, "插入数据库失败，传入参数为：" + payment, "数据库中已存在该流水号");
        }
    }

    @PostMapping("/update")
    public CommonResult update(Payment payment) {
        try {
            int result = paymentService.update(payment);
            log.info("查询结果：" + result);
            if (result > 0) {
                return new CommonResult(200, "更新数据成功", result);
            } else {
                return new CommonResult(444, "更新数据失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(444, "更新数据失败，传入参数为：" + payment, "数据库中已存在该流水号");
        }
    }

    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int result = paymentService.deleteById(id);
        log.info("查询结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败，传入id为：" + id);
        }
    }

    @GetMapping("/selectList")
    public CommonResult selectList() {
        List<Payment> payments = paymentService.selectList(new Payment());
        log.info("查询结果：" + payments);
        return new CommonResult(200, "查询成功", payments);
    }


    @GetMapping("/getTotal")
    public CommonResult getTotal() {
        int total = paymentService.getTotal(new Payment());
        log.info("查询结果：" + total);
        return new CommonResult(200, "查询成功", total);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

}
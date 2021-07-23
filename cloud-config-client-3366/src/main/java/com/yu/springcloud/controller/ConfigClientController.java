package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新配置，刷新被RefreshScope修饰的配置类，放在读取配置文件的地方(注意：@RefreshScope作用的类，不能是final类)，
              // 未配置总线的时候需要手动刷新(curl -X POST "http://localhost:3355/actuator/refresh)，请求必须是POST
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort:"+serverPort+"\t\n\n configInfo: "+configInfo;
    }

}


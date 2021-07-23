package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

@Controller
@EnableBinding(Sink.class) //触发绑定，sink表示消费者
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) //监听队列，用于消费者的队列的消息接收
    public void input(Message<String> message) {
        // message.getPayload()：获取接收到的消息
        String result = message.getPayload();
        System.out.println("消费者1号,----->接受到的消息: " + result + "\t  port: " + serverPort);
    }
}

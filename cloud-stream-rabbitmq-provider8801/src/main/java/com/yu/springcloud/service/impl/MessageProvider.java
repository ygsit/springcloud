package com.yu.springcloud.service.impl;

import com.yu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class) //触发绑定，source表示生产者
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道，用于生产者发送消息

    @Override
    public String send() {
        //定义发送流水号(定义需要发送的消息)
        String serial = UUID.randomUUID().toString();
        //创建message对象
        Message<String> message = MessageBuilder.withPayload(serial).build();
        //发送一个message对象
        output.send(message);
        System.out.println("*****send serial: "+serial);
        return null;
    }
}

package com.jk.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping
    @ResponseBody
    public void testmq(){
        String testmessage="test rabbit success";
        rabbitTemplate.convertAndSend(MQconfig.MQ_TEST_QUEUE,testmessage);
        System.out.println("成功向test队列发送一条消息");
    }
}

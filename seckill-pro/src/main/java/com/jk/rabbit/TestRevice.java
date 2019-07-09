package com.jk.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MQconfig.MQ_TEST_QUEUE)
public class TestRevice {
    @RabbitHandler
    public void testmq(String testmessage){
        System.out.println("成功消费信息："+testmessage);

    }
}

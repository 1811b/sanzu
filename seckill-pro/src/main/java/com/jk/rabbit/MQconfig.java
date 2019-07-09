package com.jk.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQconfig {

    public static final String MQ_TEST_QUEUE="test";


    @Bean
    public Queue testmq(){
        return new Queue(MQ_TEST_QUEUE);
    }
}

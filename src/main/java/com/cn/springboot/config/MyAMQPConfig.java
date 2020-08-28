package com.cn.springboot.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAMQPConfig {
    @Bean
    //把消息以json的数据形式展现出来,默认的是以java的形式
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();

    }
}

package com.cn.springboot.service;

import com.cn.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @RabbitListener(queues = "com.news")
    public void receive(Book book){
        System.out.println("接受到消息"+book);


    }
    @RabbitListener(queues = "com")
    public void receive2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());

    }
}

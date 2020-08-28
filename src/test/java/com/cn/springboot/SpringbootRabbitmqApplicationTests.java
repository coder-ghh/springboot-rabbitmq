package com.cn.springboot;


import com.cn.springboot.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    //用于创建Exchange和Queue 并且把他们绑定在一起
    AmqpAdmin amqpAdmin;
    @Test
        //单播(点对点的发送消息)
    void contextLoads() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg","这是一条消息");
        map.put("data", Arrays.asList("hello word",1234,true));
        //对象被默认序列化后发送出去,默认以java的形式发送
        //如果需要显示为json的数据形式,需要配置MyAMQConfig配置文件
        rabbitTemplate.convertAndSend("exchange.direct","com.news",new Book("西游记","吴承恩"));

    }

    @Test
    //广播,多个交换机都能接受到消息
    public  void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国演义","张三"));

    }


    @Test
    public  void createExchange(){
        //创建exchange
       // amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //创建queue
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
         //将创建的Exchange和Queue绑定
        //amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));

    }

//接收消息,在控制台打印
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("com.news");
        System.out.println(o.getClass());
        System.out.println(o);

    }

}

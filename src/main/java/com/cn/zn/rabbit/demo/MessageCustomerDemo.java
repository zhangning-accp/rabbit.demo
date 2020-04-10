package com.cn.zn.rabbit.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * @FilePath rabbit.demo com.cn.zn.rabbit.demo MessageCustomerDemo
 * @Description TODO
 * @Author zn
 * @Date 2020/4/10 11:34
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class MessageCustomerDemo {

    public static void main(String ... args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Config.RABBIT_HOST);
        factory.setPort(Config.RABBIT_PORT);
        factory.setUsername(Config.RABBIT_USER_NAME);
        factory.setPassword(Config.RABBIT_PASSWORD);

       Connection connection = factory.newConnection();
       Channel channel = connection.createChannel();
        // 1. 声明队列。 没有2会出错。 可以1，2 都没有。
        channel.queueDeclare(Config.QUEUE_NAME, true, false, false, null);
        // 2. 绑定队列到交换机 必须
        channel.queueBind(Config.QUEUE_NAME, Config.EXCHANGE_NAME, Config.ROUTING_NAME);
//        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(Config.QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}

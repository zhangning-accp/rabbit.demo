package com.cn.zn.rabbit.demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @FilePath rabbit.demo com.cn.zn.rabbit.demo MessageProducterDemo
 * @Description TODO
 * @Author zn
 * @Date 2020/4/10 11:33
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class MessageProducterDemo {
    public static void main(String ... args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Config.RABBIT_HOST);
        factory.setPort(Config.RABBIT_PORT);
        factory.setUsername(Config.RABBIT_USER_NAME);
        factory.setPassword(Config.RABBIT_PASSWORD);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String message = "Hello World!--0";

//        channel.exchangeDeclare(Config.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        // 声明队列
//        channel.queueDeclare(Config.QUEUE_NAME, true, false, false, null);
        // 绑定队列到交换机 必须
//        channel.queueBind(Config.QUEUE_NAME, Config.EXCHANGE_NAME, Config.ROUTING_NAME);
        // 指定exchange和routing key，并发送消息到exchange
        channel.basicPublish(Config.EXCHANGE_NAME, Config.ROUTING_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}

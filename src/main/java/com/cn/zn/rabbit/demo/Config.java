package com.cn.zn.rabbit.demo;

/**
 * @FilePath rabbit.demo com.cn.zn.rabbit.demo Config
 * @Description TODO
 * @Author zn
 * @Date 2020/4/10 11:38
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class Config {
    final static String RABBIT_HOST = "52.82.103.162";
    final static String RABBIT_USER_NAME = "guest";
    final static String RABBIT_PASSWORD = "guest";
    final static int RABBIT_PORT = 5672;
    final static String EXCHANGE_NAME = "rplus.service.audit:audit:exchange";
    final static String QUEUE_NAME = "rplus.service.audit.logger:audit:queue";
    final static String ROUTING_NAME = "rplus.service.audit:audit:routing";
}

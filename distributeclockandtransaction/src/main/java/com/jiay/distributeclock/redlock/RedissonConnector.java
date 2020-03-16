package com.jiay.distributeclock.redlock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取RedissonClient连接类
 */
@Component
public class RedissonConnector {
    @Value("${spring.redis.host}")
    String ip;
    @Value("${spring.redis.port}")
    String port;
    @Value("${spring.redis.password}")
    String pwd;
    RedissonClient redisson;
    @PostConstruct
    public void init(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + ip+":"+port).setPassword(pwd);
        redisson = Redisson.create(config);
    }

    public RedissonClient getClient(){
        return redisson;
    }
}

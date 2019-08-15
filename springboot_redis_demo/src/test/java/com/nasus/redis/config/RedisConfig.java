package com.nasus.redis.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Project Name:springboot_redis_demo <br/>
 * Package Name:com.nasus.redis.config <br/>
 * Date:2019/7/14 15:01 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
@Configuration
public class RedisConfig {

    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisConfig(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisTemplate<String, Object> redisTemplate() {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        //RedisSerializer<Object> jsonString = new GenericToStringSerializer<>(Object.class);
        RedisSerializer<Object> jsonString = new FastJsonRedisSerializer<>(Object.class);
        // String 的 key 和 hash 的 key 都采用 String 的序列化方式
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        // value 都采用 fastjson 的序列化方式
        redisTemplate.setValueSerializer(jsonString);
        redisTemplate.setHashValueSerializer(jsonString);
        return redisTemplate;
    }

}

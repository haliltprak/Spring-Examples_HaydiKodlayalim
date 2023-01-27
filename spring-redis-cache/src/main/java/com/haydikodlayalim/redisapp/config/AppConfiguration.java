package com.haydikodlayalim.redisapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfiguration {

    // redis ile ilgili config islemlerini burada yapiyoruz.


    // bu beanimiz connection yapmamizi saglar
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    // buradaki bean ise redis uzerinde islemler yapmamizi saglar.
    // ornegin redistemplate araciligla bir cache i verisini okuyabilir veya bir cache silebiliriz.
    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}

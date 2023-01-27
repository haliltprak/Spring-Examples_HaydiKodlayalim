package com.haydikodlayalim.redisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // Cache ozelligini aktiflestiriyoruz. Spring in ozelligi bu
public class RedisCacheApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(RedisCacheApplication.class,args);
    }
}

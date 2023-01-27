package com.haydikodlayalim.redisapp.service;

import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    public String longRunningMethod() throws InterruptedException {

        Thread.sleep(5000L); // 5 saniye bekletiyoruz. Uzun bir islem surdugunu varsaymak icin

        return "method calisti";
    }

}

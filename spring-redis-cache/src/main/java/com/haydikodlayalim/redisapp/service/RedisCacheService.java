package com.haydikodlayalim.redisapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    // bu metodun cache edilebilir oldugunu belirtiyoruz. Parametre alabilir bu annotation.
    // Boylelikle bu metodu ikinci kez cagirmada 5 saniye beklemeye gerek kalmayacak
    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000L); // 5 saniye bekletiyoruz. Uzun bir islem surdugunu varsaymak icin
        return "method calisti";
    }

    @CacheEvict(cacheNames = "mySpecialCache") // cache i siliyor, destroy ediyor
    public void clearCache(){
        System.out.println("Cache temizlendi!");
    }

}

package com.haydikodlayalim.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true) // AOP yi tum projede aktifletiriyoruz
public class SpringAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class,args);
    }
}

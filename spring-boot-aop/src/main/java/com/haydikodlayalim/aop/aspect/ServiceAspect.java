package com.haydikodlayalim.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // bu class'in bir aspect oldugunu belirtiyoruz.
@Component // Spring container icersinde init edilmesi icin ekledik
public class ServiceAspect {

    @Before("execution(* com.haydikodlayalim.aop.service.*.mesajVer(..))")
    public void mesajVerMetodundanOnce(JoinPoint joinPoint){
        System.out.println("Mesaj ver metodundan once parametre yakalandi: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.haydikodlayalim.aop.service.*.mesajVer(..))")
    public void mesajVerMetodundanSonra(JoinPoint joinPoint){
        System.out.println("Mesaj ver metodundan sonra parametre yakalandi: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

}

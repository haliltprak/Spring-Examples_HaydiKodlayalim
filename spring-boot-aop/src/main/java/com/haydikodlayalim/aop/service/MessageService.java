package com.haydikodlayalim.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String mesajVer(String parametre){
        System.out.println("Metod mesaj verdi: " + parametre);
        return parametre;
    }
}

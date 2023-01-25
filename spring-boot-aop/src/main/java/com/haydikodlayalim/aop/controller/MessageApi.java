package com.haydikodlayalim.aop.controller;

import com.haydikodlayalim.aop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody String message){
        return ResponseEntity.ok(messageService.mesajVer(message)); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }


}

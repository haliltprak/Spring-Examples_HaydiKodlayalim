package com.haydikodlayalim.api;

import com.haydikodlayalim.model.WsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin // Gelen isteklerin izinlendirilmesini sagliyor
public class ChatController {

    //(3. alternatif)
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // istekler bu metoda gelecek
    @MessageMapping("/chat") //bu metodla disariya aciyoruz. Gelen mesajlari karsiliyoruz, burada.
    //@SendTo("/topic")  gelen mesajlari herkese gonderiyoruz. (1. alternatif)
    //@SendToUser notasyonu ise spesifik bir user a mesaj gondermemizi saglar (2. alternatif)
    public void chatEndpoint(@Payload WsMessage wsMessage){
        System.out.println(wsMessage);
        simpMessagingTemplate.convertAndSend("/topic",wsMessage); // mesajlarimi /topic adresine gonderdigimizi ifade ediyoruz
    }

}

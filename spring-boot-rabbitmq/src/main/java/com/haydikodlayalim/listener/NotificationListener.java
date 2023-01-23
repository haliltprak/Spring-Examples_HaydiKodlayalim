package com.haydikodlayalim.listener;

import com.haydikodlayalim.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

// kuyruktan veri okuyan classimiz
@Service // otomatik ayaga kalkmasi icin yaptik. bunu burada eklememis olsaydik
        // RabbitMqConfiguration classinda Bean notasyonu ile tanimlamak yapmak zorundaydik.
public class NotificationListener {
    @RabbitListener(queues = "haydi-kodlayalim-queue") // bu degeri normalde application.properties ten almamiz gerekiyor.
    public void handleMessage(Notification notification){
        System.out.println("Mesaj received...");
        System.out.println(notification.toString());
    }
}

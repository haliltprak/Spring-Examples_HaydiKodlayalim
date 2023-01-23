package com.haydikodlayalim.producer;

import com.haydikodlayalim.model.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

// kuyruga data yi gonderen classimiz
@Service // otomatik ayaga kalkmasi icin yaptik. bunu burada eklememis olsaydik
        // RabbitMqConfiguration classinda Bean notasyonu ile tanimlamak yapmak zorundaydik.
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){

        Notification notification = new Notification();

        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Haydi Kodlayalim platformuna hosgeldiniz.");
        notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification){
        System.out.println("Notification Sent ID: " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification); // routingName sayesinde hangi kuyruga ve hangi exchange mesaji gonderdigini anliyor rabbitmq
    }
}

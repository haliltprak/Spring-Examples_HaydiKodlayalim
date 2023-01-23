package com.haydikodlayalim.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// rabbitmq icin gerekli konfigurasyonlari ekleyecegimiz konfigurasyon class imiz oluyor.
@Configuration
public class RabbitMqConfiguration {

    // toplamda 3 component'imiz oldugu icin 3 field ekliyoruz

    @Value("${sr.rabbit.queue.name}")
    private String queueName;
    @Value("${sr.rabbit.routing.name}")
    private String routingName; // binding key oluyor bu
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    private RabbitTemplate rabbitTemplate; // rabbit kuyruguna gidip gelmek icin bunu kullaniyoruz.

    // Kuyrugumuzu initialize ediyoruz burada
    @Bean
    public Queue queue (){
        return new Queue(queueName); // kuyruk ismini suan vermemiz yeterli
    }

    // Exchange imizi init ediyoruz.
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName); // exchange ismini vermemiz yeterli simdilik
    }

    // exchange imiz ile kuyrugumuzu birbiri ile iliskilendirmemiz gerekli
    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);  // routingName sayesinde hangi kuyruga ve hangi exchange mesaji gonderdigini anliyor rabbitmq
    }



}

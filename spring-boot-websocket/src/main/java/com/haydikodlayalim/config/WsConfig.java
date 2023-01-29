package com.haydikodlayalim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // websocketin message broker ini implementasyonunu enable ediyor
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // chat endpointine nerden cagrilirsa cagrilsin bu endpointe cevap verilsin
        // bu endpointe mesaj gonderiyoruz. Yani mesajlari bu endpoint uzerinden gonderecegiz.
        // request channel a denk geliyor
        registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // bu endpointte de mesajlari alacagiz.
        // Yani mesajlari burada dinleyecegiz, mesajlar buraya gelecek.
        // response channel a denk geliyor
        registry.enableSimpleBroker("/topic");
    }
}

package com.example.practice.config.socket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private SocketHandler socketHandler;
    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler, "myHandler/{ID}")
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*");

        registry.addHandler(socketHandler, "myHandler/{ID}")
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*")
                .withSockJS();
    }
}

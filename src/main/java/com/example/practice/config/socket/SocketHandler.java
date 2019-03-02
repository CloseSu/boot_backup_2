package com.example.practice.config.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class SocketHandler implements WebSocketHandler {

     // Websocket连接建立
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        boolean repeat = false;
        System.out.println("成功建立Websocket连接");
        session.sendMessage(new TextMessage("已建立socket連結"));
        if(repeat) {
            Thread.sleep(1000);
            session.sendMessage(new TextMessage("您已從別地登陸, 此連結已將斷開"));
            session.close();
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> socketMessage)
            throws Exception {
        String payload = (String) socketMessage.getPayload();
        Map<String, String> map = new ObjectMapper().readValue(payload, HashMap.class);
        System.out.println(map);
        System.out.println(map.get("message"));
        session.sendMessage(new TextMessage("您傳送的資料為 " + map));
    }

    // 当连接出错时，主动关闭当前连接，并从会话列表中删除该会话
    @Override
    public void handleTransportError(WebSocketSession session, Throwable error)
            throws Exception {
        if(session.isOpen()){
            session.close();
        }
        System.out.println("连接出现错误:"+error.toString());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1)
            throws Exception {
        System.out.println("Websocket连接已关闭");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

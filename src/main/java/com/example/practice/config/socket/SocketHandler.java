package com.example.practice.config.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SocketHandler implements WebSocketHandler {

    Map<String, WebSocketSession> idSessionMap= new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        System.out.println("成功建立Websocket连接");
        session.sendMessage(new TextMessage("已建立socket連結"));
        System.out.println(session);
        idSessionMap.put(session.getId(), session);
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


    @Scheduled(cron = "0/10 * * * * ?")
    public void scheduleTsk() throws IOException {
        //定時檢查是否登入
        System.out.println("每秒執行 ");
        for (Map.Entry<String, WebSocketSession> map: this.idSessionMap.entrySet()) {
            String id = map.getKey();
            WebSocketSession session = map.getValue();
            System.out.println(id);
            System.out.println("已在別處連線,此連線將關閉");
            session.sendMessage(new TextMessage("已在別處連線,此連線將關閉 "));
            session.close();
            idSessionMap.remove(id);
        }
    }
}

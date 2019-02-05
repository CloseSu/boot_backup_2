package com.example.practice.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Log
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.order}")
    private String topicOrder;

    /**
     * 发送消息
     *
     * @param messageBean 消息实例
     */
    public void sendMessage(MessageBean messageBean) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson = builder.create();
        // 将消息实例序列化为json格式的字符串
        String message = gson.toJson(messageBean);
        // 发送消息
        kafkaTemplate.send(topicOrder, message);
        // 打印消息
        log.info("\nminiooc send message：\n" + message);
    }
}

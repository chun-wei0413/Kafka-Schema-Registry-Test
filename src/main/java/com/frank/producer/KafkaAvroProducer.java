package com.frank.producer;

import com.frank.dto.Message;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {
    @Value("${topic.name}")
    private String topicName;
    @Autowired
    private KafkaTemplate<String, Message> template;

    public void send(Object payload){
        Message message = new Message();
        message.setPayload(payload);
        CompletableFuture<SendResult<String, Message>> future = template.send(topicName, UUID.randomUUID().toString(), message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message.getPayload() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message.getPayload() + "] due to : " + ex.getMessage());
            }
        });
    }
}
package com.example.quora.producers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.quora.events.ViewCountEvent;
import com.example.quora.config.KafkaConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaEventProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public void publicViewCountEvent(ViewCountEvent viewCountEvent){
        kafkaTemplate.send(KafkaConfig.TOPIC_NAME, viewCountEvent.getTargetId(),viewCountEvent)
        .whenComplete((result, err) -> {
            if(err != null){
                System.err.println("Failed to publish event: "+ err.getMessage());
            }
        });
    }

    
}

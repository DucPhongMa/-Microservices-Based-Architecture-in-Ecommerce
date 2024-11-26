package com.ducphong.store_service.kafka;

import com.ducphong.store_service.model.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
@Service
public class StoreKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreKafkaProducer.class);

    private KafkaTemplate<String, Store> kafkaTemplate;

    private final String TOPIC_NAME= "request-store";

    public StoreKafkaProducer(KafkaTemplate<String, Store> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Store data) {

        LOGGER.info(String.format("Message sent %s", data.toString()));

        Message<Store> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME).build();

        kafkaTemplate.send(message);
    }
}

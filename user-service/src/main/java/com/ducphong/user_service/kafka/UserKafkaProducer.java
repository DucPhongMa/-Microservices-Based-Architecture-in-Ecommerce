package com.ducphong.user_service.kafka;

import com.ducphong.user_service.dto.UserKafkaDTO;
import com.ducphong.user_service.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaProducer {

    private static final String TOPIC = "user-store-info";

    private final KafkaTemplate<String, UserKafkaDTO> kafkaTemplate;

    public UserKafkaProducer(KafkaTemplate<String, UserKafkaDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {

        UserKafkaDTO userKafkaDTO = new UserKafkaDTO(
                user.getEmail(),
                user.getStoreName(),
                user.getIndustry(),
                user.getStoreLogoImage(),
                user.getStoreAddress(),
                user.getStorePhoneNumber(),
                user.getId()
        );

        kafkaTemplate.send(TOPIC, userKafkaDTO);
        System.out.println("Produced user: " + userKafkaDTO);
    }
}

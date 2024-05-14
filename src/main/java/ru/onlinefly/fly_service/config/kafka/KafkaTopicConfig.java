package ru.onlinefly.fly_service.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.data.kafka.channels.fly-channel.name}")
    private String flyEventTopic;

    @Bean
    public NewTopic commentEventTopic() {
        return new NewTopic(flyEventTopic, 1, (short) 1);
    }
}

package ru.onlinefly.fly_service.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.onlinefly.fly_service.dto.event.FlyEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class FlyEventPublisher {

    @Value("${spring.data.kafka.channels.fly-channel.name}")
    private String flyEventTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void publish(FlyEvent flyEvent) {
        try {
            kafkaTemplate.send(flyEventTopic, objectMapper.writeValueAsString(flyEvent));
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
        log.info("Published fly event: {}", flyEvent);
    }
}

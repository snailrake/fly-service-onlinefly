package ru.onlinefly.fly_service.response;


import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {

    @Positive
    private long questionId;

    @Positive
    private long answerId;
}

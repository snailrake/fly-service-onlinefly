package ru.onlinefly.fly_service.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlyResponse {

    @Positive
    private long flyId;

    @Valid
    private List<QuestionResponse> questionResponses;

    @Positive
    private long time;

    private boolean lostFocus;
}

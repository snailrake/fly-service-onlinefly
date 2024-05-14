package ru.onlinefly.fly_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlyDto {

    private long id;
    private String name;
    private List<QuestionDto> questions;
    private long time;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

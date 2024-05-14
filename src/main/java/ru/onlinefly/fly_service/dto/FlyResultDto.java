package ru.onlinefly.fly_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlyResultDto {

    private long id;
    private StudentDto user;
    private FlyShortDto fly;
    private String score;
    private String time;
    private boolean lostFocus;
}

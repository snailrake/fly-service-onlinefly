package ru.onlinefly.fly_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlyShortDto {

    private long id;
    private String name;
    private String subject;
    private long time;
}

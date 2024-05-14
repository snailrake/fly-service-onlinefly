package ru.onlinefly.fly_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private String id;
    private String name;
    private TeamDto team;
    private String mail;
    private String role;
}

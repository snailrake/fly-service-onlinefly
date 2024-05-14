package ru.onlinefly.fly_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @NotBlank(message = "Empty login")
    private String login;

    @NotBlank(message = "Empty password")
    private String password;
}

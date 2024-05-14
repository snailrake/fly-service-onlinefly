package ru.onlinefly.fly_service.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.onlinefly.fly_service.dto.FlyDto;
import ru.onlinefly.fly_service.dto.FlyNameDto;
import ru.onlinefly.fly_service.dto.FlyShortDto;
import ru.onlinefly.fly_service.response.FlyResponse;
import ru.onlinefly.fly_service.service.FlyService;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fly")
public class FlyController {

    private final FlyService flyService;

    @PostMapping("/res")
    public void handleTestResult(@RequestBody @Valid FlyResponse flyResponse, @AuthenticationPrincipal UserDetails userDetails) {
        flyService.handleTestResult(flyResponse, userDetails.getUsername());
    }

    @GetMapping
    public List<FlyShortDto> getAll() {
        return flyService.getAll();
    }

    @GetMapping("/{id}")
    public FlyDto getById(@PathVariable @Positive long id) {
        return flyService.getById(id);
    }

    @GetMapping("/name/{id}")
    public FlyNameDto getFlyName(@PathVariable @Positive long id) {
        return flyService.getFlyName(id);
    }
}

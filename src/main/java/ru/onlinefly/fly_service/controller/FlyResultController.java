package ru.onlinefly.fly_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.onlinefly.fly_service.dto.FlyResultDto;
import ru.onlinefly.fly_service.service.FlyResultService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/res")
@RequiredArgsConstructor
public class FlyResultController {

    private final FlyResultService flyResultService;

    @GetMapping
    public List<FlyResultDto> getAll() {
        return flyResultService.getAll();
    }

    @GetMapping("/student")
    public List<FlyResultDto> getByStudentId(@AuthenticationPrincipal UserDetails userDetails) {
        return flyResultService.getByStudentId(userDetails.getUsername());
    }

    @GetMapping("/team/{teamId}")
    public List<FlyResultDto> getByTeamId(@PathVariable long teamId) {
        return flyResultService.getByTeamId(teamId);
    }

    @GetMapping("/fly")
    public List<FlyResultDto> findAllByTeamIdAndFlyId(@RequestParam long teamId, @RequestParam long flyId) {
        return flyResultService.findAllByTeamIdAndFlyId(teamId, flyId);
    }
}

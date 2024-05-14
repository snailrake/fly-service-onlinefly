package ru.onlinefly.fly_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.onlinefly.fly_service.dto.TeamDto;
import ru.onlinefly.fly_service.service.TeamService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/team")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<TeamDto> getAll() {
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public TeamDto getById(@PathVariable long id) {
        return teamService.getById(id);
    }
}

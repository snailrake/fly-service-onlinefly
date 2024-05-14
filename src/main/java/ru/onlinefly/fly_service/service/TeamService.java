package ru.onlinefly.fly_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onlinefly.fly_service.dto.TeamDto;
import ru.onlinefly.fly_service.mapper.TeamMapper;
import ru.onlinefly.fly_service.model.Team;
import ru.onlinefly.fly_service.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Transactional(readOnly = true)
    public List<TeamDto> getAll() {
        List<Team> teams = teamRepository.findAll();
        return teamMapper.toDto(teams);
    }

    @Transactional
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Transactional(readOnly = true)
    public TeamDto getById(long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Группа с id %d не найдена", id)));
        return teamMapper.toDto(team);
    }

    @Transactional(readOnly = true)
    public Team findById(long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Группа с id %d не найдена", id)));
    }
}

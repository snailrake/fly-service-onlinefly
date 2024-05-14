package ru.onlinefly.fly_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onlinefly.fly_service.dto.FlyResultDto;
import ru.onlinefly.fly_service.mapper.FlyResultMapper;
import ru.onlinefly.fly_service.model.FlyResult;
import ru.onlinefly.fly_service.repository.FlyResultRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlyResultService {

    private final FlyResultRepository flyResultRepository;
    private final FlyResultMapper flyResultMapper;

    @Transactional(readOnly = true)
    public List<FlyResultDto> findAllByTeamIdAndFlyId(long teamId, long flyId) {
        List<FlyResult> results = flyResultRepository.findAllByUserTeamIdAndFlyIdOrderByScoreDesc(teamId, flyId);
        return flyResultMapper.toDto(results);
    }

    @Transactional
    public FlyResult save(FlyResult flyResult) {
        return flyResultRepository.save(flyResult);
    }

    @Transactional(readOnly = true)
    public List<FlyResultDto> getAll() {
        List<FlyResult> flyResults = flyResultRepository.findAll();
        return flyResultMapper.toDto(flyResults);
    }

    @Transactional(readOnly = true)
    public List<FlyResultDto> getByStudentId(String studentId) {
        List<FlyResult> flyResults = flyResultRepository.findByUserId(studentId);
        return flyResultMapper.toDto(flyResults);
    }

    @Transactional(readOnly = true)
    public List<FlyResultDto> getByTeamId(long teamId) {
        List<FlyResult> flyResults = flyResultRepository.findByUserTeamId(teamId);
        return flyResultMapper.toDto(flyResults);
    }
}

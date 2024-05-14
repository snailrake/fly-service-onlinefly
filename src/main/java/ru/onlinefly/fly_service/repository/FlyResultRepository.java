package ru.onlinefly.fly_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlinefly.fly_service.model.FlyResult;

import java.util.List;

@Repository
public interface FlyResultRepository extends JpaRepository<FlyResult, String> {

    List<FlyResult> findByUserId(String studentId);


    List<FlyResult> findByUserTeamId(long teamId);

    List<FlyResult> findAllByUserTeamIdAndFlyIdOrderByScoreDesc(long teamId, long flyId);
}

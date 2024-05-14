package ru.onlinefly.fly_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlinefly.fly_service.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}

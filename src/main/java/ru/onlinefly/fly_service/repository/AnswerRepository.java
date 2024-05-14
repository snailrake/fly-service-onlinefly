package ru.onlinefly.fly_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlinefly.fly_service.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

package ru.onlinefly.fly_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlinefly.fly_service.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

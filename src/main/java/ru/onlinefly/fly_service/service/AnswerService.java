package ru.onlinefly.fly_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onlinefly.fly_service.model.Answer;
import ru.onlinefly.fly_service.repository.AnswerRepository;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer findById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Ответ с id %d не найден", id)));
    }
}

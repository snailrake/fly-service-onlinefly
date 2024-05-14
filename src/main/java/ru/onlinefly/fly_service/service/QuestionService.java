package ru.onlinefly.fly_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onlinefly.fly_service.dto.QuestionContentDto;
import ru.onlinefly.fly_service.mapper.QuestionMapper;
import ru.onlinefly.fly_service.model.Question;
import ru.onlinefly.fly_service.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Transactional(readOnly = true)
    public Question findById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Вопрос с id %d не найден", id)));
    }

    @Transactional(readOnly = true)
    public QuestionContentDto getQuestionContent(long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Вопрос с id %d не найден", id)));
        return questionMapper.toContentDto(question);
    }
}

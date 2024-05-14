package ru.onlinefly.fly_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.onlinefly.fly_service.dto.QuestionContentDto;
import ru.onlinefly.fly_service.service.QuestionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
public class QuestionController {

    public final QuestionService questionService;

    @GetMapping("/content/{id}")
    public QuestionContentDto getQuestionContent(@PathVariable long id) {
        return questionService.getQuestionContent(id);
    }
}

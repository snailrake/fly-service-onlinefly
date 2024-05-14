package ru.onlinefly.fly_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onlinefly.fly_service.dto.FlyDto;
import ru.onlinefly.fly_service.dto.FlyNameDto;
import ru.onlinefly.fly_service.dto.FlyShortDto;
import ru.onlinefly.fly_service.dto.QuestionResponseDto;
import ru.onlinefly.fly_service.dto.event.FlyEvent;
import ru.onlinefly.fly_service.exception.DataValidationException;
import ru.onlinefly.fly_service.mapper.FlyMapper;
import ru.onlinefly.fly_service.model.Fly;
import ru.onlinefly.fly_service.model.FlyResult;
import ru.onlinefly.fly_service.model.User;
import ru.onlinefly.fly_service.publisher.FlyEventPublisher;
import ru.onlinefly.fly_service.repository.FlyRepository;
import ru.onlinefly.fly_service.response.FlyResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlyService implements ApplicationContextAware {

    private final FlyRepository flyRepository;
    private final FlyMapper flyMapper;
    private final StudentService studentService;
    private final QuestionService questionService;
    private final TeamService teamService;
    private final FlyEventPublisher flyEventPublisher;
    private final FlyResultService flyResultService;
    private ApplicationContext applicationContext;

    @Transactional
    public void handleTestResult(FlyResponse flyResponse, String login) {
        FlyService flyService = (FlyService) applicationContext.getBean("flyService");
        Fly fly = flyService.findById(flyResponse.getFlyId());
        User user = studentService.findByLogin(login);
        validateStudentHaveFly(user, flyResponse, fly);
        AtomicLong rightAnswersCnt = new AtomicLong(0);
        List<QuestionResponseDto> questionResponses = getQuestionResponses(flyResponse, rightAnswersCnt);
        double score = BigDecimal.valueOf(((double) rightAnswersCnt.get() / (double) flyResponse.getQuestionResponses().size()) * 100)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
        saveFlyResult(user, fly, score, flyResponse.getTime(), flyResponse.isLostFocus());
        publishFlyEvent(fly, user, flyResponse, score, questionResponses);
    }

    @Transactional(readOnly = true)
    public List<FlyShortDto> getAll() {
        List<Fly> flys = flyRepository.findAll();
        return flyMapper.toShortDto(flys);
    }

    @Transactional(readOnly = true)
    public FlyDto getById(long id) {
        Fly fly = flyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(""));
        FlyDto flyDto = flyMapper.toDto(fly);
        Collections.shuffle(flyDto.getQuestions());
        flyDto.setQuestions(flyDto.getQuestions().subList(0, Math.min(flyDto.getQuestions().size(), (int) fly.getQuestionsCount())));
        return flyDto;
    }

    @Transactional(readOnly = true)
    public Fly findById(long id) {
        return flyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(""));
    }

    @Transactional(readOnly = true)
    public FlyNameDto getFlyName(long id) {
        FlyService flyService = (FlyService) applicationContext.getBean("flyService");
        return flyMapper.toFlyNameDto(flyService.findById(id));
    }

    private List<QuestionResponseDto> getQuestionResponses(FlyResponse flyResponse, AtomicLong rightAnswersCnt) {
        List<QuestionResponseDto> questionResponses = new ArrayList<>();
        flyResponse.getQuestionResponses().forEach(questionResponse -> {
            if (questionService.findById(questionResponse.getQuestionId()).getAnswer().getId() == questionResponse.getAnswerId()) {
                rightAnswersCnt.incrementAndGet();
                questionResponses.add(QuestionResponseDto.builder().questionId(questionResponse.getQuestionId()).isCorrect(true).build());
            } else {
                questionResponses.add(QuestionResponseDto.builder().questionId(questionResponse.getQuestionId()).isCorrect(false).build());
            }
        });
        return questionResponses;
    }

    private void validateStudentHaveFly(User user, FlyResponse flyResponse, Fly fly) {
        FlyService flyService = (FlyService) applicationContext.getBean("flyService");
        List<Fly> flys = new ArrayList<>();
        if (user != null) {
            flys = user.getResults().stream()
                    .map(FlyResult::getFly)
                    .filter(fly1 -> fly1.equals(fly))
                    .toList();
        }
        if (!flys.isEmpty()) {
            throw new DataValidationException("Студент уже выполнил эту летучку");

        }
    }

    private FlyResult saveFlyResult(User user, Fly fly, double score, long time, boolean lostFocus) {
        return flyResultService.save(FlyResult.builder()
                .user(user)
                .fly(fly)
                .score(score)
                .time(time)
                .build());
    }

    private void publishFlyEvent(Fly fly, User user, FlyResponse flyResponse, double score, List<QuestionResponseDto> questionResponses) {
        flyEventPublisher.publish(FlyEvent.builder()
                .studentId(user.getId())
                .teamId(user.getTeam().getId())
                .flyId(flyResponse.getFlyId())
                .name(user.getName())
                .email(user.getMail())
                .flyName(fly.getName())
                .score(score)
                .time(flyResponse.getTime())
                .questionResponses(questionResponses)
                .lostFocus(flyResponse.isLostFocus())
                .build());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

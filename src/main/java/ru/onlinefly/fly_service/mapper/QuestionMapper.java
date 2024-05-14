package ru.onlinefly.fly_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.onlinefly.fly_service.dto.QuestionContentDto;
import ru.onlinefly.fly_service.dto.QuestionDto;
import ru.onlinefly.fly_service.model.Question;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = AnswerMapper.class)
public interface QuestionMapper {

    QuestionDto toDto(Question question);

    QuestionContentDto toContentDto(Question question);
}

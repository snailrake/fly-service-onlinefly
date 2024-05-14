package ru.onlinefly.fly_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.onlinefly.fly_service.dto.AnswerDto;
import ru.onlinefly.fly_service.model.Answer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    AnswerDto toDto(Answer answer);
}

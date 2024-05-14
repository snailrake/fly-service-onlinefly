package ru.onlinefly.fly_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ru.onlinefly.fly_service.dto.FlyDto;
import ru.onlinefly.fly_service.dto.FlyNameDto;
import ru.onlinefly.fly_service.dto.FlyShortDto;
import ru.onlinefly.fly_service.model.Fly;
import ru.onlinefly.fly_service.model.Subject;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = QuestionMapper.class)
public interface FlyMapper {

    FlyDto toDto(Fly fly);

    List<FlyShortDto> toShortDto(List<Fly> flyList);

    @Mapping(target = "subject", source = "subject", qualifiedByName = "subjectToString")
    FlyShortDto toShortDto(Fly fly);

    FlyNameDto toFlyNameDto(Fly fly);

    @Named("subjectToString")
    default String subjectToString(Subject subject) {
        return subject.getName();
    }
}
package ru.onlinefly.fly_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ru.onlinefly.fly_service.dto.FlyResultDto;
import ru.onlinefly.fly_service.model.FlyResult;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {StudentMapper.class, FlyMapper.class})
public interface FlyResultMapper {


    List<FlyResultDto> toDto(List<FlyResult> flyResults);

    @Mapping(target = "score", source = "score", qualifiedByName = "scoreToString")
    @Mapping(target = "time", source = "time", qualifiedByName = "timeToString")
    FlyResultDto toDto(FlyResult flyResult);

    @Named("timeToString")
    default String toTimeString(long time) {
        long hours = time / 3600;
        long minutes = (time % 3600) / 60;
        long seconds = time % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Named("scoreToString")
    default String toStringScore(double score) {
        return String.format("%.1f%%", score);
    }
}

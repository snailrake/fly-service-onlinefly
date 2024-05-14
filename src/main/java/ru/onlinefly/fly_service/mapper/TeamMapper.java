package ru.onlinefly.fly_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.onlinefly.fly_service.dto.TeamDto;
import ru.onlinefly.fly_service.model.Team;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    List<TeamDto> toDto(List<Team> teams);

    TeamDto toDto(Team team);
}

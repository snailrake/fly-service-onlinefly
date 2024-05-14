package ru.onlinefly.fly_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.onlinefly.fly_service.dto.StudentDto;
import ru.onlinefly.fly_service.dto.StudentNameDto;
import ru.onlinefly.fly_service.model.User;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = TeamMapper.class)
public interface StudentMapper {

    List<StudentDto> toDto(List<User> users);

    StudentDto toDto(User user);

    StudentNameDto toStudentNameDto(User user);
}

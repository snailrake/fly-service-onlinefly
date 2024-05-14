package ru.onlinefly.fly_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.onlinefly.fly_service.dto.LoginDto;
import ru.onlinefly.fly_service.dto.StudentDto;
import ru.onlinefly.fly_service.dto.StudentNameDto;
import ru.onlinefly.fly_service.mapper.StudentMapper;
import ru.onlinefly.fly_service.model.User;
import ru.onlinefly.fly_service.repository.StudentRepository;
import ru.onlinefly.fly_service.utils.JwtTokenUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public String login(LoginDto loginDTO) {
        return login(loginDTO.getLogin(), loginDTO.getPassword());
    }

    private String login(String login, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenUtils.generateToken(authentication);
    }

    public StudentDto getByLogin(String login) {
        User user = studentRepository.findById(login)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Студент с id %s не найден", login)));
        return studentMapper.toDto(user);
    }

    public User findByLogin(String login) {
        return studentRepository.findById(login)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Студент с id %s не найден", login)));
    }

    public List<StudentDto> getAll() {
        List<User> users = studentRepository.findAll();
        return studentMapper.toDto(users);
    }

    public StudentNameDto getNameById(String id) {
        User user = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Студент с id %s не найден", id)));
        return studentMapper.toStudentNameDto(user);
    }

    public User save(User user) {
        return studentRepository.save(user);
    }

    public User findByMail(String mail) {
        return studentRepository.findByMail(mail);
    }
}

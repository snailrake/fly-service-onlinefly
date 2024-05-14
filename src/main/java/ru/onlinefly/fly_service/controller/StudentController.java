package ru.onlinefly.fly_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.onlinefly.fly_service.dto.LoginDto;
import ru.onlinefly.fly_service.dto.StudentDto;
import ru.onlinefly.fly_service.dto.StudentNameDto;
import ru.onlinefly.fly_service.service.StudentService;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/login")
    String login(@RequestBody @Valid LoginDto loginDTO) {
        return studentService.login(loginDTO);
    }

    @GetMapping("/id")
    public StudentDto getByLogin(@AuthenticationPrincipal UserDetails userDetails) {
        return studentService.getByLogin(userDetails.getUsername());
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/name/{id}")
    public StudentNameDto getShortStudent(@PathVariable String id) {
        return studentService.getNameById(id);
    }
}

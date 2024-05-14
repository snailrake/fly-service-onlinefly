package ru.onlinefly.fly_service.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.onlinefly.fly_service.model.User;
import ru.onlinefly.fly_service.repository.StudentRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nicknameOrEmail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(nicknameOrEmail);
        return user.map(User::new)
                .orElseThrow(() -> new UsernameNotFoundException("[" + nicknameOrEmail + "] not found!"));
    }
}
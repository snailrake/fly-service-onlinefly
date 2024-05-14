package ru.onlinefly.fly_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlinefly.fly_service.model.User;

@Repository
public interface StudentRepository extends JpaRepository<User, String> {

    User findByMail(String mail);
}

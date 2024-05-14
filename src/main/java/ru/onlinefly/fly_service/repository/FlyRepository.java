package ru.onlinefly.fly_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlinefly.fly_service.model.Fly;

@Repository
public interface FlyRepository extends JpaRepository<Fly, Long> {

}

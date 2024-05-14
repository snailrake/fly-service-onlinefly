package ru.onlinefly.fly_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fly")
public class Fly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 256, nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "fly", cascade = CascadeType.REMOVE)
    private List<Question> questions;

    @OneToMany(mappedBy = "fly", cascade = CascadeType.REMOVE)
    private List<FlyResult> results;

    @Column(name = "questions_per_try", nullable = false)
    private long questionsCount;

    @Column(name = "time", nullable = false)
    private long time;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;
}

package ru.onlinefly.fly_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fly_result")
public class FlyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "fly_id", nullable = false)
    private Fly fly;

    @Column(name = "score", nullable = false)
    private double score;

    @Column(name = "time", nullable = false)
    private long time;

    @Column(name = "lost_focus", nullable = false)
    private boolean lostFocus;
}

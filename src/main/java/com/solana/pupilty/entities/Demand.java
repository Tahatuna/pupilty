package com.solana.pupilty.entities;


import com.solana.pupilty.enums.DemandStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "demand")
@Data
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pupil_id", nullable = false)
    private Pupil pupil;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "educater_id")
    private Educater educater;

    @Enumerated(EnumType.STRING)
    private DemandStatus status;
}

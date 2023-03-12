package com.solana.pupilty.repository;

import com.solana.pupilty.entities.Demand;
import com.solana.pupilty.entities.Educater;
import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.entities.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand, Long> {
    List<Demand> findByPupil(Pupil pupil);

    List<Demand> findByLesson(Lesson lesson);

    List<Demand> findByEducater(Educater educater);
}

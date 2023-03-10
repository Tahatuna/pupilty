package com.solana.pupilty.repository;

import com.solana.pupilty.entities.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PupilRepository extends JpaRepository<Pupil, Long> {
    Pupil findByUserName(String userName);
}

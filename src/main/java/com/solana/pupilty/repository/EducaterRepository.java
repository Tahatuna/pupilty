package com.solana.pupilty.repository;

import com.solana.pupilty.entities.Educater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducaterRepository extends JpaRepository<Educater, Long> {
    Educater findByUserName(String userName);
}

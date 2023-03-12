package com.solana.pupilty.service.demand;

import com.solana.pupilty.entities.Demand;
import com.solana.pupilty.entities.Educater;
import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.entities.Pupil;
import com.solana.pupilty.enums.DemandStatus;
import com.solana.pupilty.repository.DemandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandService {
    private final DemandRepository demandRepository;

    public DemandService(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }

    public Demand createDemand(Demand demand) {
        return demandRepository.save(demand);
    }

    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }

    public List<Demand> getDemandsByPupil(Pupil pupil) {
        return demandRepository.findByPupil(pupil);
    }

    public List<Demand> getDemandsByLesson(Lesson lesson) {
        return demandRepository.findByLesson(lesson);
    }

    public List<Demand> getDemandsByEducater(Educater educater) {
        return demandRepository.findByEducater(educater);
    }

    public Demand getDemandById(Long id) {
        return demandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid demand id: " + id));
    }

    public void updateDemandStatus(Long id, DemandStatus status) {
        Demand demand = getDemandById(id);
        demand.setStatus(status);
        demandRepository.save(demand);
    }

    public void deleteDemand(Long id) {
        demandRepository.deleteById(id);
    }
}
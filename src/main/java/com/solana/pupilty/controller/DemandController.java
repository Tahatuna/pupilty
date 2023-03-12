package com.solana.pupilty.controller;

import com.solana.pupilty.entities.Demand;
import com.solana.pupilty.entities.Educater;
import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.entities.Pupil;
import com.solana.pupilty.enums.DemandStatus;
import com.solana.pupilty.service.demand.DemandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demands")
public class DemandController {

    private final DemandService demandService;

    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping
    public ResponseEntity<Demand> createDemand(@RequestBody Demand demand) {
        Demand createdDemand = demandService.createDemand(demand);
        return new ResponseEntity<>(createdDemand, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Demand>> getAllDemands() {
        List<Demand> demands = demandService.getAllDemands();
        return new ResponseEntity<>(demands, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable Long id) {
        Demand demand = demandService.getDemandById(id);
        return new ResponseEntity<>(demand, HttpStatus.OK);
    }

    @GetMapping("/pupil/{pupilId}")
    public ResponseEntity<List<Demand>> getDemandsByPupil(@PathVariable Long pupilId) {
        Pupil pupil = new Pupil();
        pupil.setId(pupilId);
        List<Demand> demands = demandService.getDemandsByPupil(pupil);
        return new ResponseEntity<>(demands, HttpStatus.OK);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<Demand>> getDemandsByLesson(@PathVariable Long lessonId) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonId);
        List<Demand> demands = demandService.getDemandsByLesson(lesson);
        return new ResponseEntity<>(demands, HttpStatus.OK);
    }

    @GetMapping("/educater/{educaterId}")
    public ResponseEntity<List<Demand>> getDemandsByEducater(@PathVariable Long educaterId) {
        Educater educater = new Educater();
        educater.setId(educaterId);
        List<Demand> demands = demandService.getDemandsByEducater(educater);
        return new ResponseEntity<>(demands, HttpStatus.OK);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Void> updateDemandStatus(@PathVariable Long id, @PathVariable DemandStatus status) {
        demandService.updateDemandStatus(id, status);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemand(@PathVariable Long id) {
        demandService.deleteDemand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
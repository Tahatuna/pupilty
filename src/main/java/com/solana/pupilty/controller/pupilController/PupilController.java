package com.solana.pupilty.controller.pupilController;

import com.solana.pupilty.entities.Demand;
import com.solana.pupilty.entities.Pupil;
import com.solana.pupilty.request.pupilRequest.CreateOnePupilRequest;
import com.solana.pupilty.response.Response;
import com.solana.pupilty.service.pupil.PupilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pupils", produces = "application/json")
public class PupilController {

    private final PupilService pupilService;

    public PupilController(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    @PostMapping("/createOnePupil")
    public Response createOnePupil(@RequestBody CreateOnePupilRequest request) {
        return pupilService.createOnePupil(request);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pupil> getByPupilId(@PathVariable Long id) {
        Optional<Pupil> pupil = pupilService.getPupilById(id);
        if (pupil.isPresent()) {
            return new ResponseEntity<>(pupil.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}


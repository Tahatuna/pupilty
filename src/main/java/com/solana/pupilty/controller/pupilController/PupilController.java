package com.solana.pupilty.controller.pupilController;

import com.solana.pupilty.request.pupilRequest.CreateOnePupilRequest;
import com.solana.pupilty.response.Response;
import com.solana.pupilty.service.pupil.PupilService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pupils", produces = "application/json")
public class PupilController {

    private PupilService pupilService;

    public PupilController(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    @PostMapping("/createOnePupil")
    public Response createOnePupil (@RequestBody CreateOnePupilRequest request) {
       return pupilService.createOnePupil(request);
   }


}

//bir pupil oluştur +
//pupil login olur+
//log out olur+
//pupil abonelik başlatabilir
//***
//pupil birden fazla talep oluşturabilir (eger aboneligi varsa)
//pupil talebi kabul edilirse bilgi alabilir


//---
//educater register olur +
//educater login olur+
//logout+
//educater lesson oluştur +
//educater lesson sil
//educater talep alabilir ve bunu onaylar

//---
//lessonsları nasıl getirecegiz+
package com.solana.pupilty.controller.educaterController;


import com.solana.pupilty.entities.Educater;
import com.solana.pupilty.exception.CustomException;
import com.solana.pupilty.request.educaterRequest.CreateLessonRequest;
import com.solana.pupilty.request.educaterRequest.CreateOneEducaterRequest;
import com.solana.pupilty.request.educaterRequest.EducaterRequest;
import com.solana.pupilty.response.Response;
import com.solana.pupilty.service.educater.EducaterService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping(value = "/educater", produces = "application/json")
public class EducaterController {

    private final EducaterService educaterService;

    public EducaterController(EducaterService educaterService) {
        this.educaterService = educaterService;
    }

    @PostMapping("/createOneEducater")
    public Response createOneEducater(@ModelAttribute CreateOneEducaterRequest request, @RequestParam("imageFile") MultipartFile file) throws CustomException {
        return educaterService.createOneEducater(request, file);
    }

    @PostMapping("/createLesson")
    public Response createLesson(@RequestBody CreateLessonRequest request){
        return educaterService.createLesson(request);
    }

    @PostMapping("getByIdEducater")
    public Optional<Educater> getByIdEducater(@RequestBody EducaterRequest request){
      return educaterService.getByIdEducater(request);
    }

}





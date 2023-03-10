package com.solana.pupilty.service;

import com.solana.pupilty.constants.ResultConstants;
import com.solana.pupilty.constants.ResultLoginConstants;
import com.solana.pupilty.entities.Educater;
import com.solana.pupilty.entities.Pupil;
import com.solana.pupilty.enums.SubscriptionStatus;
import com.solana.pupilty.repository.EducaterRepository;
import com.solana.pupilty.repository.PupilRepository;
import com.solana.pupilty.request.LoginRequest;
import com.solana.pupilty.response.LoginEducaterResponse;
import com.solana.pupilty.response.LoginPupilResponse;
import com.solana.pupilty.response.Response;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class LoginService {

    private final EducaterRepository educaterRepository;
    private final PupilRepository pupilRepository;

    public LoginService(EducaterRepository educaterRepository, PupilRepository pupilRepository) {
        this.educaterRepository = educaterRepository;
        this.pupilRepository = pupilRepository;
    }


    public Object login(LoginRequest request) {

        if (Stream.of(request.getUserName(), request.getPassword()).anyMatch(Objects::isNull)) {
            return new Response(ResultConstants.MISSING_PARAMETER_ERROR_CODE, ResultConstants.MISSING_PARAMETER_ERROR_DESC);
        }

        Educater educater = educaterRepository.findByUserName(request.getUserName());
        Pupil pupil = pupilRepository.findByUserName(request.getUserName());

        if (educater != null && educater.getPassword().equals(request.getPassword())) {
            return new LoginEducaterResponse(educater.getId(), educater.getUserName());
        } else if (pupil != null && pupil.getPassword().equals(request.getPassword())) {
            return new LoginPupilResponse(pupil.getId(), pupil.getUserName(), pupil.getSubscriptionStatus());
        } else if (educater != null && !educater.getPassword().equals(request.getPassword()) && pupil == null) {
            return new Response(ResultLoginConstants.WRONG_PASSWORD_CODE, ResultLoginConstants.WRONG_PASSWORD_DESC);
        } else if (pupil != null && !pupil.getPassword().equals(request.getPassword()) && educater == null) {
            return new Response(ResultLoginConstants.WRONG_PASSWORD_CODE, ResultLoginConstants.WRONG_PASSWORD_DESC);
        } else {
            return new Response(ResultConstants.GENERAL_ERROR_CODE, ResultConstants.GENERAL_ERROR_DESC);
        }
    }


}

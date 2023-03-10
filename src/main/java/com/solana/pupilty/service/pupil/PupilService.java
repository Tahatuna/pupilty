package com.solana.pupilty.service.pupil;

import com.solana.pupilty.constants.ResultConstants;
import com.solana.pupilty.entities.Pupil;
import com.solana.pupilty.repository.EducaterRepository;
import com.solana.pupilty.repository.PupilRepository;
import com.solana.pupilty.request.pupilRequest.CreateOnePupilRequest;
import com.solana.pupilty.response.Response;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

import static com.solana.pupilty.enums.SubscriptionStatus.NOT_SUBSCRIBED;

@Service
public class PupilService {


    private PupilRepository pupilRepository;
    private EducaterRepository educaterRepository;

    public PupilService(PupilRepository pupilRepository, EducaterRepository educaterRepository) {
        this.pupilRepository = pupilRepository;
        this.educaterRepository = educaterRepository;
    }

    public Response createOnePupil(CreateOnePupilRequest request) {

        if (Stream.of(request.getUserName(), request.getName(), request.getLastName(),
                        request.getTelNo(), request.getMail(), request.getPassword())
                .anyMatch(Objects::isNull)) {
            return new Response(ResultConstants.MISSING_PARAMETER_ERROR_CODE, ResultConstants.MISSING_PARAMETER_ERROR_DESC);
        }

        if (pupilRepository.findByUserName(request.getUserName()) != null || educaterRepository.findByUserName(request.getUserName()) !=null) {
            return new Response(ResultConstants.USERNAME_ALREADY_EXISTS_ERROR_CODE, ResultConstants.USERNAME_ALREADY_EXISTS_ERROR_DESC);
        }

        Pupil createPupil = new Pupil();
        createPupil.setUserName(request.getUserName());
        createPupil.setName(request.getName());
        createPupil.setLastName(request.getLastName());
        createPupil.setTelNo(request.getTelNo());
        createPupil.setMail(request.getMail());
        createPupil.setPassword(request.getPassword());
        createPupil.setSubscriptionStatus(NOT_SUBSCRIBED);
        pupilRepository.save(createPupil);

        return new Response(ResultConstants.GENERAL_SUCCESS_CODE, ResultConstants.GENERAL_SUCCESS_DESC);

    }

}

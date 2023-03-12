package com.solana.pupilty.service.educater;

import com.solana.pupilty.constants.ResultConstants;
import com.solana.pupilty.entities.Educater;
import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.entities.ProfileImage;
import com.solana.pupilty.exception.CustomException;
import com.solana.pupilty.repository.EducaterRepository;
import com.solana.pupilty.repository.LessonRepository;
import com.solana.pupilty.repository.PupilRepository;
import com.solana.pupilty.request.educaterRequest.CreateLessonRequest;
import com.solana.pupilty.request.educaterRequest.CreateOneEducaterRequest;
import com.solana.pupilty.request.educaterRequest.EducaterRequest;
import com.solana.pupilty.response.Response;
import com.solana.pupilty.util.ImageUtility;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EducaterService {


    private final PupilRepository pupilRepository;
    private final EducaterRepository educaterRepository;
    private final LessonRepository lessonRepository;

    public EducaterService(PupilRepository pupilRepository, EducaterRepository educaterRepository, LessonRepository lessonRepository) {
        this.pupilRepository = pupilRepository;
        this.educaterRepository = educaterRepository;
        this.lessonRepository = lessonRepository;
    }

    public Response createOneEducater(CreateOneEducaterRequest request, MultipartFile file) throws CustomException {


        try {
            if (Stream.of(request.getUserName(), request.getName(), request.getLastName(),
                            request.getTelNo(), request.getMail(), request.getPassword(), request.getProfileDesc())
                    .anyMatch(Objects::isNull)) {
                return new Response(ResultConstants.MISSING_PARAMETER_ERROR_CODE, ResultConstants.MISSING_PARAMETER_ERROR_DESC);
            }

            if (pupilRepository.findByUserName(request.getUserName()) != null || educaterRepository.findByUserName(request.getUserName()) != null) {
                return new Response(ResultConstants.USERNAME_ALREADY_EXISTS_ERROR_CODE, ResultConstants.USERNAME_ALREADY_EXISTS_ERROR_DESC);
            }

            Educater createEducater = new Educater();
            ProfileImage image = new ProfileImage(file.getOriginalFilename(), file.getContentType(), ImageUtility.compressBytes(file.getBytes()));

            createEducater.setImage(image);
            image.setEducater(createEducater);
            createEducater.setUserName(request.getUserName());
            createEducater.setName(request.getName());
            createEducater.setLastName(request.getLastName());
            createEducater.setTelNo(request.getTelNo());
            createEducater.setMail(request.getMail());
            createEducater.setPassword(request.getPassword());
            createEducater.setProfileDesc(request.getProfileDesc());
            educaterRepository.save(createEducater);

            return new Response(ResultConstants.GENERAL_SUCCESS_CODE, ResultConstants.GENERAL_SUCCESS_DESC);
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage() + " educater create edilerken hata olustu");
        }
    }

    public Response createLesson(CreateLessonRequest request) {

        if (Stream.of(request.getLessonName(), request.getCategory(), request.getEducater_id(), request.getDescription(), request.getPrice()).anyMatch(Objects::isNull)) {
            return new Response(ResultConstants.MISSING_PARAMETER_ERROR_CODE, ResultConstants.MISSING_PARAMETER_ERROR_DESC);
        }

        Educater educater = educaterRepository.findById(request.getEducater_id()).orElse(null);
        if (educater == null) {
            throw new IllegalArgumentException("Invalid educater ID: " + request.getEducater_id());
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(request.getLessonName());
        lesson.setDescription(request.getDescription());
        lesson.setPrice(request.getPrice());
        lesson.setCategory(request.getCategory());
        lesson.setEducater(educater);
        lessonRepository.save(lesson);
        educater.getLessons().add(lesson); // lessons özelliğine yeni Lesson nesnesi ekleniyor
        educaterRepository.save(educater); // Educater nesnesi güncelleniyor
        return new Response(ResultConstants.GENERAL_SUCCESS_CODE, ResultConstants.GENERAL_SUCCESS_DESC);
    }

    public Optional<Educater> getByIdEducater(EducaterRequest request) {
        Optional<Educater> educater = educaterRepository.findById(request.getId());
        if(educater.isPresent()){
            Educater fetchedEducater = educater.get();
            return Optional.of(fetchedEducater);
        }else{
            return Optional.empty();
        }
    }

}


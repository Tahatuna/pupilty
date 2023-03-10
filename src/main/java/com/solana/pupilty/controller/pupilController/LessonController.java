package com.solana.pupilty.controller.pupilController;

import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.enums.Category;
import com.solana.pupilty.service.pupil.LessonsService;
import com.solana.pupilty.util.ImageUtility;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lessons", produces = "application/json")
public class LessonController {

    private final LessonsService lessonsService;

    public LessonController(LessonsService lessonsService) {
        this.lessonsService = lessonsService;
    }

    @GetMapping(value = "/getAllLessons")
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = lessonsService.getAllLessons();
        for (Lesson lesson : lessons) {
            if (lesson.getEducater().getImage() != null) {
                lesson.getEducater().getImage().setImageByte(ImageUtility.decompressBytes(lesson.getEducater().getImage().getImageByte()));
            }
        }
        return lessons;
    }

    @GetMapping(value = "getLessonsByCategory")
    public List<Lesson> getLessonsByCategory(@RequestParam(required = false) Category category) {
        return lessonsService.getLessonsByCategory(category);
    }

}

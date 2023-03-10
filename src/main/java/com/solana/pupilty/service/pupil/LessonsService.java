package com.solana.pupilty.service.pupil;

import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.enums.Category;
import com.solana.pupilty.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonsService {

    private LessonRepository lessonRepository;

    public LessonsService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

/*    public List<Lesson> getLessonsByCategory(Category category) {
        return lessonRepository.findByCategory(category);
    }*/

    public List<Lesson> getLessonsByCategory(Category category) {
        return lessonRepository.findByCategory(category);
    }

}

package com.solana.pupilty.repository;

import com.solana.pupilty.entities.Lesson;
import com.solana.pupilty.enums.Category;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByCategory(Category category);

   /* List<Lesson> findByCategoryWithEducater(Category category);*/

    public default List<Lesson> findByCategoryWithEducater(Category category) {
        List<Lesson> lessons = findByCategory(category);
        lessons.forEach(lesson -> Hibernate.initialize(lesson.getEducater()));
        return lessons;
    }



}

package com.example.examprojectrestapi.converter.lesson;

import com.example.examprojectrestapi.dto.request.InstructorRequest;
import com.example.examprojectrestapi.dto.request.LessonRequest;
import com.example.examprojectrestapi.model.Instructor;
import com.example.examprojectrestapi.model.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonConverterRequest {

    public Lesson create(LessonRequest lessonRequest) {
        if (lessonRequest == null) return null;
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;
    }

    public void update(Lesson lesson , LessonRequest lessonRequest) {
        if (lessonRequest.getLessonName() != null) {
            lesson.setLessonName(lessonRequest.getLessonName());
        }
    }

}

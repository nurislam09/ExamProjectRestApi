package com.example.examprojectrestapi.converter.lesson;

import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.dto.response.LessonResponse;
import com.example.examprojectrestapi.model.Instructor;
import com.example.examprojectrestapi.model.Lesson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonConverterResponse {

    public LessonResponse create(Lesson lesson) {
        if (lesson == null) return null;
        LessonResponse lessonResponse = new LessonResponse();
        lessonResponse.setId(lesson.getId());
        lessonResponse.setLessonName(lesson.getLessonName());
        return lessonResponse;
    }

    public List<LessonResponse> getAll(List<Lesson> lessons) {
        List<LessonResponse> lessonResponses = new ArrayList<>();
        for (Lesson l : lessons) {
            lessonResponses.add(create(l));
        }
        return lessonResponses;
    }
}

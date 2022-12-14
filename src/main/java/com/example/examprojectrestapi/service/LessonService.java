package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.LessonRequest;
import com.example.examprojectrestapi.dto.response.LessonResponse;
import com.example.examprojectrestapi.model.Lesson;

import java.util.List;

public interface LessonService {
    List<LessonResponse> getAllLesson();

    List<LessonResponse> getAllLessonById(Long courseId);

    LessonResponse getLessonById(Long lessonId);

    LessonResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    LessonResponse updateLesson(Long lessonId, LessonRequest lessonRequest);

    LessonResponse deleteLesson(Long lessonId);
}

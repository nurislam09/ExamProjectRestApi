package com.example.examprojectrestapi.service.impl;

import com.example.examprojectrestapi.converter.lesson.LessonConverterRequest;
import com.example.examprojectrestapi.converter.lesson.LessonConverterResponse;
import com.example.examprojectrestapi.dto.request.LessonRequest;
import com.example.examprojectrestapi.dto.response.LessonResponse;
import com.example.examprojectrestapi.model.Course;
import com.example.examprojectrestapi.model.Lesson;
import com.example.examprojectrestapi.repository.CourseRepository;
import com.example.examprojectrestapi.repository.LessonRepository;
import com.example.examprojectrestapi.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonConverterResponse lessonConverterResponse;
    private final LessonConverterRequest lessonConverterRequest;
    private final CourseRepository courseRepository;

    @Override
    public List<LessonResponse> getAllLesson() {
        return lessonConverterResponse.getAll(lessonRepository.findAll());
    }

    @Override
    public List<LessonResponse> getAllLessonById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return lessonConverterResponse.getAll(course.getLessons());
    }

    @Override
    public LessonResponse getLessonById(Long lessonId) {
        return lessonConverterResponse.create(lessonRepository.findById(lessonId).get());
    }

    @Override
    public LessonResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepository.findById(courseId).get();
        Lesson lesson= lessonConverterRequest.create(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonConverterResponse.create(lesson);
    }

    @Override
    public LessonResponse updateLesson(Long lessonId, LessonRequest lessonRequest) {
        Lesson lesson=lessonRepository.findById(lessonId).get();
        lessonConverterRequest.update(lesson,lessonRequest);
        return lessonConverterResponse.create(lessonRepository.save(lesson));
    }

    @Override
    public LessonResponse deleteLesson(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        lessonRepository.delete(lesson);
        return lessonConverterResponse.create(lesson);
    }
}

package com.example.examprojectrestapi.controller;

import com.example.examprojectrestapi.dto.request.LessonRequest;
import com.example.examprojectrestapi.dto.response.LessonResponse;
import com.example.examprojectrestapi.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/getAllLesson")
    public List<LessonResponse> getAllCourse() {
        return lessonService.getAllLesson();
    }

    @GetMapping("/getAllLessonById/{courseId}")
    public List<LessonResponse> getAllLessonByCourseId(@PathVariable Long courseId) {
        return lessonService.getAllLessonById(courseId);
    }

    @GetMapping("/getLessonById/{lessonId}")
    public LessonResponse getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    @PostMapping("/saveLesson/{courseId}")
    public LessonResponse saveLesson(@PathVariable Long courseId,
                                             @RequestBody LessonRequest lessonRequest) throws IOException {
        return lessonService.saveLesson(courseId, lessonRequest);
    }

    @PutMapping("/updateLesson/{lessonId}")
    public LessonResponse UpdateLesson(@PathVariable Long lessonId, @RequestBody LessonRequest lessonRequest) throws IOException {
        return lessonService.updateLesson(lessonId, lessonRequest);
    }

    @DeleteMapping("/deleteLesson/{lessonId}")
    public LessonResponse deleteLesson(@PathVariable Long lessonId) {
        return lessonService.deleteLesson(lessonId);
    }

}

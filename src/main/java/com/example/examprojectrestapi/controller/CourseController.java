package com.example.examprojectrestapi.controller;

import com.example.examprojectrestapi.dto.request.CourseRequest;
import com.example.examprojectrestapi.dto.response.CourseResponse;
import com.example.examprojectrestapi.dto.response.GroupResponse;
import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.service.CourseService;
import com.example.examprojectrestapi.service.GroupService;
import com.example.examprojectrestapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final GroupService groupService;
    private final InstructorService instructorService;

    @GetMapping("/getAllCourse")
    public List<CourseResponse> getAllCourse (){
        return courseService.getAllCourse();
    }

    @GetMapping("/getAllCourseById/{companyId}")
    public List<CourseResponse> getAllCourseById (@PathVariable Long companyId){
        return courseService.getAllCourseById(companyId);
    }

    @GetMapping("/getCourseById/{courseId}")
    public CourseResponse getCourseById(@PathVariable Long courseId){
      return courseService.getCourseById(courseId);
    }

    @PostMapping("/saveCourse/{companyId}")
    public CourseResponse saveCourse(@PathVariable Long companyId,@RequestBody CourseRequest courseRequest) throws IOException {
        return courseService.saveCourse(companyId, courseRequest);
    }

    @PutMapping("/updateCourse/{courseId}")
    public CourseResponse updateCourse(@PathVariable Long courseId,@RequestBody CourseRequest courseRequest) throws IOException {
        return courseService.updateCourse(courseId, courseRequest);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public CourseResponse deleteCourse(@PathVariable Long courseId){
        return courseService.deleteCourse(courseId);
    }

    @PostMapping("/assignGroupToCourse/{courseId}/{groupId}")
    private GroupResponse assignGroupToCourse(@PathVariable Long courseId,
                                              @PathVariable Long groupId) throws IOException {
        return groupService.assignGroup(courseId, groupId);
    }

    @PostMapping("/assignInstructor/{instructorId}/{courseId}")
    private InstructorResponse assignInstructorToCourse(@PathVariable Long instructorId,
                                                        @PathVariable Long courseId) throws IOException {
        return instructorService.assignInstructor(instructorId, courseId);
    }
}

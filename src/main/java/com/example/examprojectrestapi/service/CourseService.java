package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.CourseRequest;
import com.example.examprojectrestapi.dto.response.CourseResponse;
import com.example.examprojectrestapi.model.Course;

import java.io.IOException;
import java.util.List;

public interface CourseService {

    List<CourseResponse> getAllCourse();

    List<CourseResponse> getAllCourseById(Long companyId);

    CourseResponse getCourseById(Long companyId);

    CourseResponse saveCourse(Long companyId, CourseRequest courseRequest) throws IOException;

    CourseResponse updateCourse(Long id, CourseRequest courseRequest) throws IOException;

    CourseResponse deleteCourse(Long id);
}

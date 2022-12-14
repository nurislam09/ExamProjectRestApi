package com.example.examprojectrestapi.service.impl;

import com.example.examprojectrestapi.converter.course.CourseConverterRequest;
import com.example.examprojectrestapi.converter.course.CourseConverterResponse;
import com.example.examprojectrestapi.dto.request.CourseRequest;
import com.example.examprojectrestapi.dto.response.CourseResponse;
import com.example.examprojectrestapi.model.Company;
import com.example.examprojectrestapi.model.Course;
import com.example.examprojectrestapi.repository.CompanyRepository;
import com.example.examprojectrestapi.repository.CourseRepository;
import com.example.examprojectrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseConverterRequest courseConverterRequest;
    private final CourseConverterResponse courseConverterResponse;
    private final CompanyRepository companyRepository;


    @Override
    public List<CourseResponse> getAllCourse() {
        return courseConverterResponse.getAll(courseRepository.findAll());
    }

    @Override
    public List<CourseResponse> getAllCourseById(Long companyId) {
       Company company = companyRepository.findById(companyId).get();
        return courseConverterResponse.getAll(company.getCourses());
    }

    @Override
    public CourseResponse getCourseById(Long companyId) {
        Course course = courseRepository.findById(companyId).get();
        return courseConverterResponse.create(course);
    }

    @Override
    public CourseResponse saveCourse(Long companyId, CourseRequest courseRequest) throws IOException {
        Company company = companyRepository.findById(companyId).get();
        Course course = courseConverterRequest.create(courseRequest);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseConverterResponse.create(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) throws IOException {
        Course course = courseRepository.findById(id).get();
        courseConverterRequest.update(course,courseRequest);
        return courseConverterResponse.create(courseRepository.save(course));
    }

    @Override
    public CourseResponse deleteCourse(Long id) {
        Course course =courseRepository.findById(id).get();
        courseRepository.delete(course);
        return courseConverterResponse.create(course);
    }
}

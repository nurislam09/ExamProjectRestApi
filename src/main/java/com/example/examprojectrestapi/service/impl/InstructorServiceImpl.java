package com.example.examprojectrestapi.service.impl;

import com.example.examprojectrestapi.converter.instructor.InstructorConverterRequest;
import com.example.examprojectrestapi.converter.instructor.InstructorConverterResponse;
import com.example.examprojectrestapi.dto.request.InstructorRequest;
import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.model.Course;
import com.example.examprojectrestapi.model.Group;
import com.example.examprojectrestapi.model.Instructor;
import com.example.examprojectrestapi.repository.CourseRepository;
import com.example.examprojectrestapi.repository.GroupRepository;
import com.example.examprojectrestapi.repository.InstructorRepository;
import com.example.examprojectrestapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorConverterResponse instructorConverterResponse;
    private final InstructorConverterRequest instructorConverterRequest;
    private  final CourseRepository courseRepository;

    @Override
    public List<InstructorResponse> getAllInstructor() {
        return instructorConverterResponse.getAll(instructorRepository.findAll());
    }

    @Override
    public List<InstructorResponse> getAllInstructorById(Long courseId) {
       Course course =courseRepository.findById(courseId).get();
        return instructorConverterResponse.getAll(course.getInstructors());
    }

    @Override
    public InstructorResponse getInstructorById(Long instructorId) {
        return instructorConverterResponse.create(instructorRepository.findById(instructorId).get());
    }

    @Override
    public InstructorResponse saveInstructor(Long courseId, InstructorRequest instructorRequest) throws IOException {
        Course course = courseRepository.findById(courseId).get();
        Instructor instructor = instructorConverterRequest.create(instructorRequest);
        course.addInstructor(instructor);
        instructor.setCourse(course);
        instructorRepository.save(instructor);
        return instructorConverterResponse.create(instructor);
    }

    @Override
    public InstructorResponse updateInstructor(Long instructorId, InstructorRequest instructorRequest) throws IOException {
        Instructor instructor = instructorRepository.findById(instructorId).get();
        instructorConverterRequest.update(instructor, instructorRequest);
        return instructorConverterResponse.create(instructorRepository.save(instructor));
    }

    @Override
    public InstructorResponse deleteInstructor(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).get();
        instructorRepository.delete(instructor);
        return instructorConverterResponse.create(instructor);
    }
}

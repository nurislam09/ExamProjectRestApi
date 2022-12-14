package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.InstructorRequest;
import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.model.Instructor;

import java.io.IOException;
import java.util.List;

public interface InstructorService {

    List<InstructorResponse> getAllInstructor();
    List<InstructorResponse> getAllInstructorById(Long courseId);
    InstructorResponse getInstructorById(Long instructorId);
    InstructorResponse saveInstructor(Long groupId, InstructorRequest instructorRequest) throws IOException;
    InstructorResponse updateInstructor(Long instructorId, InstructorRequest instructorRequest) throws IOException;
    InstructorResponse deleteInstructor(Long instructorId);
    InstructorResponse assignInstructor(Long instructorId, Long courseId) throws IOException;
}

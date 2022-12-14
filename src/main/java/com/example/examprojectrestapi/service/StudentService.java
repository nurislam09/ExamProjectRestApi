package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.StudentRequest;
import com.example.examprojectrestapi.dto.response.StudentResponse;
import com.example.examprojectrestapi.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudent();

    List<StudentResponse> getAllStudentById(Long groupId);

    StudentResponse getStudentById(Long studentId);

    StudentResponse saveStudent(Long groupId, StudentRequest studentRequest)throws IOException;

    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) throws IOException;

    StudentResponse deleteStudent(Long studentId);

   // StudentResponse assignStudent(Long courseId, Long studentId) throws IOException;
}

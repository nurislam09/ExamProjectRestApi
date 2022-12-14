package com.example.examprojectrestapi.service.impl;

import com.example.examprojectrestapi.converter.student.StudentConverterRequest;
import com.example.examprojectrestapi.converter.student.StudentConverterResponse;
import com.example.examprojectrestapi.dto.request.StudentRequest;
import com.example.examprojectrestapi.dto.response.StudentResponse;
import com.example.examprojectrestapi.model.Group;
import com.example.examprojectrestapi.model.Student;
import com.example.examprojectrestapi.repository.GroupRepository;
import com.example.examprojectrestapi.repository.StudentRepository;
import com.example.examprojectrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverterRequest studentConverterRequest;
    private final StudentConverterResponse studentConverterResponse;
    private final GroupRepository groupRepository;

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentConverterResponse.getAll(studentRepository.findAll());
    }

    @Override
    public List<StudentResponse> getAllStudentById(Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        return studentConverterResponse.getAll(group.getStudents());
    }

    @Override
    public StudentResponse getStudentById(Long studentId) {
        return studentConverterResponse.create(studentRepository.findById(studentId).get());
    }

    @Override
    public StudentResponse saveStudent(Long groupId, StudentRequest studentRequest) throws IOException {
        Group group=groupRepository.findById(groupId).get();
        Student student= studentConverterRequest.create(studentRequest);
        group.addStudent(student);
        student.setGroup(group);
        studentRepository.save(student);
        return studentConverterResponse.create(student);
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) throws IOException {
        Student student = studentRepository.findById(studentId).get();
        studentConverterRequest.update(student,studentRequest);
        return studentConverterResponse.create(studentRepository.save(student));
    }

    @Override
    public StudentResponse deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return studentConverterResponse.create(student);
    }
}

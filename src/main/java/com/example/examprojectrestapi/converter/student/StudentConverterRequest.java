package com.example.examprojectrestapi.converter.student;

import com.example.examprojectrestapi.dto.request.StudentRequest;
import com.example.examprojectrestapi.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverterRequest {

    public Student create(StudentRequest studentRequest) {
        if (studentRequest == null) return null;
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        return student;
    }

    public void update(Student student, StudentRequest studentRequest) {
        if (studentRequest.getFirstName() != null) {
            student.setFirstName(studentRequest.getFirstName());
        }
        if (studentRequest.getLastName() != null) {
            student.setLastName(studentRequest.getLastName());
        }
        if (studentRequest.getPhoneNumber() != null) {
            student.setPhoneNumber(studentRequest.getPhoneNumber());
        }
        if (studentRequest.getEmail() != null) {
            student.setEmail(studentRequest.getEmail());
        }
        if (studentRequest.getStudyFormat() != null) {
            student.setStudyFormat(studentRequest.getStudyFormat());
        }
    }
}

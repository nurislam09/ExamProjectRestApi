package com.example.examprojectrestapi.converter.student;

import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.dto.response.LessonResponse;
import com.example.examprojectrestapi.dto.response.StudentResponse;
import com.example.examprojectrestapi.model.Instructor;
import com.example.examprojectrestapi.model.Lesson;
import com.example.examprojectrestapi.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentConverterResponse {

    public StudentResponse create(Student student) {
        if (student == null) return null;
        StudentResponse studentResponse =  new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setPhoneNumber(student.getPhoneNumber());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setStudyFormat(student.getStudyFormat());
        return studentResponse;
    }

    public List<StudentResponse> getAll(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student s : students) {
            studentResponses.add(create(s));
        }
        return studentResponses;
    }
}

package com.example.examprojectrestapi.controller;

import com.example.examprojectrestapi.dto.request.StudentRequest;
import com.example.examprojectrestapi.dto.response.StudentResponse;
import com.example.examprojectrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<StudentResponse> getAllCourse() {
        return studentService.getAllStudent();
    }

    @GetMapping("/getAllStudentById/{groupId}")
    public List<StudentResponse> getAllStudentByCourseId(@PathVariable Long groupId) {
        return studentService.getAllStudentById(groupId);
    }

    @GetMapping("/getStudentById/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/saveStudent/{groupId}")
    public StudentResponse saveStudent(@PathVariable Long groupId,
                                      @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.saveStudent(groupId, studentRequest);
    }

    @PutMapping("/updateStudent/{studentId}")
    public StudentResponse UpdateStudent(@PathVariable Long studentId, @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.updateStudent(studentId, studentRequest);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public StudentResponse deleteInstructorById(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }
}

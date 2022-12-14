package com.example.examprojectrestapi.controller;

import com.example.examprojectrestapi.dto.request.InstructorRequest;
import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/getAllInstructor")
    public List<InstructorResponse> getAllCourse() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/getAllInstructorByCourseId/{courseId}")
    public List<InstructorResponse> getAllInstructorByCourseId(@PathVariable Long courseId) {
        return instructorService.getAllInstructorById(courseId);
    }

    @GetMapping("/getInstructorById/{instructorId}")
    public InstructorResponse getInstructorById(@PathVariable Long instructorId) {
        return instructorService.getInstructorById(instructorId);
    }

    @PostMapping("/saveInstructor/{courseId}")
    public InstructorResponse saveInstructor(@PathVariable Long courseId,
                                             @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.saveInstructor(courseId, instructorRequest);
    }

    @PutMapping("/updateInstructor/{instructorId}")
    public InstructorResponse UpdateInstructor(@PathVariable Long instructorId, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.updateInstructor(instructorId, instructorRequest);
    }

    @DeleteMapping("/deleteInstructor/{instructorId}")
    public InstructorResponse deleteInstructorById(@PathVariable Long instructorId) {
        return instructorService.deleteInstructor(instructorId);
    }
}

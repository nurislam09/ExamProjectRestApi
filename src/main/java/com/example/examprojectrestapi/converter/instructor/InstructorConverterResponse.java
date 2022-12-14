package com.example.examprojectrestapi.converter.instructor;

import com.example.examprojectrestapi.dto.response.GroupResponse;
import com.example.examprojectrestapi.dto.response.InstructorResponse;
import com.example.examprojectrestapi.model.Group;
import com.example.examprojectrestapi.model.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorConverterResponse {

    public InstructorResponse create(Instructor instructor) {
        if (instructor == null) return null;
        InstructorResponse instructorResponse = new InstructorResponse();
        instructorResponse.setId(instructor.getId());
        instructorResponse.setFirstname(instructor.getFirstname());
        instructorResponse.setLastname(instructor.getLastname());
        instructorResponse.setPhoneNumber(instructor.getPhoneNumber());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setSpecialization(instructor.getSpecialization());
        return instructorResponse;
    }

    public List<InstructorResponse> getAll(List<Instructor> instructors) {
        List<InstructorResponse> instructorResponses = new ArrayList<>();
        for (Instructor i : instructors) {
            instructorResponses.add(create(i));
        }
        return instructorResponses;
    }
}

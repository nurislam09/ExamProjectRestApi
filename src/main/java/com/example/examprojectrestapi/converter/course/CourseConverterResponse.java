package com.example.examprojectrestapi.converter.course;

import com.example.examprojectrestapi.dto.response.CompanyResponse;
import com.example.examprojectrestapi.dto.response.CourseResponse;
import com.example.examprojectrestapi.model.Company;
import com.example.examprojectrestapi.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseConverterResponse {

    public CourseResponse create( Course course) {
        if (course == null) return null;
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDescription(course.getDescription());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;
    }

    public List<CourseResponse> getAll(List<Course> courses) {
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course c : courses) {
            courseResponses.add(create(c));
        }
        return courseResponses;
    }
}

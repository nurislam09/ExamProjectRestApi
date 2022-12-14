package com.example.examprojectrestapi.converter.course;

import com.example.examprojectrestapi.dto.request.CompanyRequest;
import com.example.examprojectrestapi.dto.request.CourseRequest;
import com.example.examprojectrestapi.model.Company;
import com.example.examprojectrestapi.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverterRequest {

    public Course create(CourseRequest courseRequest){
        if(courseRequest == null) return null;
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        return course;
    }

    public void update(Course course,CourseRequest courseRequest) {
        if (courseRequest.getCourseName()!= null)
            course.setCourseName(courseRequest.getCourseName());
        if(courseRequest.getDescription()!= null)
            course.setDescription(courseRequest.getDescription());
        if(courseRequest.getDuration() != null)
            course.setDuration(courseRequest.getDuration());
    }
}

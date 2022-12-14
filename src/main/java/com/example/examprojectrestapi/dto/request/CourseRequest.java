package com.example.examprojectrestapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    private String courseName;

    private Integer duration;

    private String description;
}

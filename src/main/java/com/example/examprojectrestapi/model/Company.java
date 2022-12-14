package com.example.examprojectrestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @SequenceGenerator(name = "company_gen",sequenceName = "company_seq",allocationSize = 1)
    @GeneratedValue(generator = "company_gen",strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(length = 500)
    private String companyName;

    @Column(length = 500)
    private String locatedCountry;

    @OneToMany(cascade = {ALL},fetch = LAZY,mappedBy = "company")
    private List<Course> courses;

//    @Column
//    private int countOfStudent=0;

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

    public void addCourse(Course course){
        if (course == null) courses = new ArrayList<>();
        courses.add(course);
    }
//    public void plus(){
//        countOfStudent++;
//    }
//    public void minus(){
//        countOfStudent--;
//    }

}

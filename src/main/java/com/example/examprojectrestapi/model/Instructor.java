package com.example.examprojectrestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen", sequenceName = "instructor_seq", allocationSize = 1)
    private Long id;

    @Column(length = 500)
    private String firstname;

    @Column(length = 500)
    private String lastname;

    @Column(length = 500)
    private String phoneNumber;

    @Column(length = 500)
    private String email;

    @Column
    private String specialization;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = EAGER)
    private Course course;

    private int student = 0;


    public Instructor(String firstname, String lastname, String phoneNumber, String email, String specialization) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.specialization = specialization;
    }
    public void plus() {
        student++;
    }
    public void minus() {
        student--;
    }
}

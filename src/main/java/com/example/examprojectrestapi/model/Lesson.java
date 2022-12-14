package com.example.examprojectrestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    private Long id;

    @Column(length = 100000)
    private String lessonName;

    @ManyToOne(cascade = {MERGE, DETACH, REFRESH, PERSIST}, fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade = {MERGE, DETACH, REFRESH, REMOVE}, fetch = FetchType.LAZY, mappedBy = "lesson")
    private List<Task> tasks;

    public Lesson(String lessonName, Course course) {
        this.lessonName = lessonName;
        this.course = course;
    }

    public void addTask(Task task){
        if (tasks==null){
            tasks=new ArrayList<>();
        }
        tasks.add(task);
    }
}

package com.example.examprojectrestapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name = "task_gen", sequenceName = "task_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_gen")
    private Long id;



    @Column(length = 500)
    private String taskName;

    @Column(length = 500)
    private String taskText;

    @Column(length = 500)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadLine;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST}, fetch = LAZY)
    private Lesson lesson;

    public Task(String taskName, String taskText, Date deadLine) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadLine = deadLine;
    }

}

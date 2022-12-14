package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.TaskRequest;
import com.example.examprojectrestapi.dto.response.TaskResponse;
import com.example.examprojectrestapi.model.Task;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAllTask();

    List<TaskResponse> getAllTaskById(Long lessonId);

    TaskResponse getTaskById(Long taskId);

    TaskResponse saveTask(Long lessonId, TaskRequest taskRequest);

    TaskResponse updateTask(Long taskId, TaskRequest taskRequest);

    TaskResponse deleteTask(Long taskId);
}

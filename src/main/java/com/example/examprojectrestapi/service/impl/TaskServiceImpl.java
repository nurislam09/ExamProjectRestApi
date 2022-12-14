package com.example.examprojectrestapi.service.impl;

import com.example.examprojectrestapi.converter.task.TaskConverterRequest;
import com.example.examprojectrestapi.converter.task.TaskConverterResponse;
import com.example.examprojectrestapi.dto.request.TaskRequest;
import com.example.examprojectrestapi.dto.response.TaskResponse;
import com.example.examprojectrestapi.model.Lesson;
import com.example.examprojectrestapi.model.Task;
import com.example.examprojectrestapi.repository.LessonRepository;
import com.example.examprojectrestapi.repository.TaskRepository;
import com.example.examprojectrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverterRequest taskConverterRequest;
    private final TaskConverterResponse taskConverterResponse;
    private final LessonRepository lessonRepository;


    @Override
    public List<TaskResponse> getAllTask() {
        return taskConverterResponse.getAll(taskRepository.findAll());
    }

    @Override
    public List<TaskResponse> getAllTaskById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        return taskConverterResponse.getAll(lesson.getTasks());
    }

    @Override
    public TaskResponse getTaskById(Long taskId) {
        return taskConverterResponse.create(taskRepository.findById(taskId).get());
    }

    @Override
    public TaskResponse saveTask(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson=lessonRepository.findById(lessonId).get();
        Task task= taskConverterRequest.create(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return taskConverterResponse.create(task);
    }

    @Override
    public TaskResponse updateTask(Long taskId, TaskRequest taskRequest) {
        Task task= taskRepository.findById(taskId).get();
        taskConverterRequest.update(task,taskRequest);
        return taskConverterResponse.create(taskRepository.save(task));
    }

    @Override
    public TaskResponse deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        taskRepository.delete(task);
        return taskConverterResponse.create(task);
    }
}

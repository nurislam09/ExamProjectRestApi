package com.example.examprojectrestapi.controller;

import com.example.examprojectrestapi.dto.request.TaskRequest;
import com.example.examprojectrestapi.dto.response.TaskResponse;
import com.example.examprojectrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getAllTask")
    public List<TaskResponse> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/getAllTaskById/{lessonId}")
    public List<TaskResponse> getAllTaskByLessonId(@PathVariable Long lessonId) {
        return taskService.getAllTaskById(lessonId);
    }

    @GetMapping("/getTaskById/{taskId}")
    public TaskResponse getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/saveTask/{lessonId}")
    public TaskResponse saveTask(@PathVariable Long lessonId,
                                 @RequestBody TaskRequest taskRequest) throws IOException {
        return taskService.saveTask(lessonId, taskRequest);
    }

    @PutMapping("/updateTask/{taskId}")
    public TaskResponse UpdateTask(@PathVariable Long taskId, @RequestBody TaskRequest taskRequest) throws IOException {
        return taskService.updateTask(taskId, taskRequest);
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public TaskResponse deleteTaskById(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }
}

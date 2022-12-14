package com.example.examprojectrestapi.converter.task;

import com.example.examprojectrestapi.dto.request.StudentRequest;
import com.example.examprojectrestapi.dto.request.TaskRequest;
import com.example.examprojectrestapi.dto.response.TaskResponse;
import com.example.examprojectrestapi.model.Student;
import com.example.examprojectrestapi.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskConverterRequest {

    public Task create(TaskRequest taskRequest) {
        if (taskRequest == null) return null;
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadLine(taskRequest.getDeadLine());
        return task;
    }

    public void update(Task task, TaskRequest taskRequest) {
        if (taskRequest.getTaskName() != null) {
            task.setTaskName(taskRequest.getTaskName());
        }
        if (taskRequest.getTaskText() != null) {
            task.setTaskText(taskRequest.getTaskText());
        }
        if (taskRequest.getDeadLine() != null) {
            task.setDeadLine(taskRequest.getDeadLine());
        }
    }
}

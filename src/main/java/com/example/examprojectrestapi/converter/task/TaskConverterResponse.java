package com.example.examprojectrestapi.converter.task;

import com.example.examprojectrestapi.dto.response.StudentResponse;
import com.example.examprojectrestapi.dto.response.TaskResponse;
import com.example.examprojectrestapi.model.Student;
import com.example.examprojectrestapi.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverterResponse {

    public TaskResponse  create (Task task) {
        if (task == null) return null;
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTaskName(task.getTaskName());
        taskResponse.setTaskText(task.getTaskText());
        taskResponse.setDeadLine(task.getDeadLine());
        return taskResponse;
    }

    public List<TaskResponse> getAll(List<Task> tasks) {
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task t : tasks) {
            taskResponses.add(create(t));
        }
        return taskResponses;
    }
}

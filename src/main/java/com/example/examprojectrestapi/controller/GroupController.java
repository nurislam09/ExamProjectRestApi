package com.example.examprojectrestapi.controller;


import com.example.examprojectrestapi.dto.request.GroupRequest;
import com.example.examprojectrestapi.dto.response.GroupResponse;
import com.example.examprojectrestapi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
  //  private final StudentService studentService;

    @GetMapping("/getAllGroup")
    public List<GroupResponse> getAllGroup() {
        return groupService.getAllGroup();
    }

    @GetMapping("/getAllGroupById/{courseId}")
    public List<GroupResponse> getAllGroupById(@PathVariable Long courseId) {
        return groupService.getAllGroupById(courseId);
    }

    @GetMapping("/getGroupById/{id}")
    public GroupResponse getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping("/saveGroup/{courseId}")
    public GroupResponse saveGroup(@PathVariable Long courseId, @RequestBody GroupRequest groupRequest) {
        return groupService.saveGroup(courseId, groupRequest);
    }

    @PutMapping("/updateGroup/{groupId}")
    public GroupResponse updateGroupByCourseId(@PathVariable Long groupId, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(groupId, groupRequest);
    }

    @DeleteMapping("/deleteGroup/{courseId}/{groupId}")
    public GroupResponse deleteGroup(@PathVariable Long courseId, @PathVariable Long groupId) {
        return groupService.deleteGroup(courseId, groupId);
    }
//
//    @PostMapping("/assignStudent/{id}/{groupId}")
//    private StudentResponse assignStudent(@PathVariable Long id,
//                                          @PathVariable Long groupId) throws IOException {
//        return studentService.assignStudent(id, groupId);
//    }
}

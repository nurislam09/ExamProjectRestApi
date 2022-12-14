package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.GroupRequest;
import com.example.examprojectrestapi.dto.response.GroupResponse;
import com.example.examprojectrestapi.model.Group;

import java.io.IOException;
import java.util.List;

public interface GroupService {

    List<GroupResponse> getAllGroup();

    List<GroupResponse> getAllGroupById(Long courseId);

    GroupResponse getGroupById(Long groupId);

    GroupResponse saveGroup(Long courseId, GroupRequest groupRequest);

    GroupResponse updateGroup(Long groupId, GroupRequest groupRequest);

     GroupResponse deleteGroup(Long courseId,Long groupId);

    GroupResponse assignGroup(Long courseId, Long groupId) throws IOException;
}

package com.example.examprojectrestapi.converter.group;


import com.example.examprojectrestapi.dto.request.GroupRequest;
import com.example.examprojectrestapi.model.Group;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GroupConverterRequest {

    public Group create(GroupRequest groupRequest) {
        if (groupRequest == null) return null;
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setImage(groupRequest.getImage());
        group.setDataOfStart(LocalDate.now());
        return group;
    }

    public void update(Group group, GroupRequest groupRequest) {
        if (groupRequest.getGroupName() != null) {
            group.setGroupName(groupRequest.getGroupName());
        }
        if (groupRequest.getImage() != null) {
            group.setImage(groupRequest.getImage());
        }
        group.setDataOfStart(LocalDate.now());
    }
}

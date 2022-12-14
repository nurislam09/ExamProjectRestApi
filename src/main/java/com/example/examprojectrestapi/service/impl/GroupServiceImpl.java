package com.example.examprojectrestapi.service.impl;



import com.example.examprojectrestapi.converter.group.GroupConverterRequest;
import com.example.examprojectrestapi.converter.group.GroupConverterResponse;
import com.example.examprojectrestapi.dto.request.GroupRequest;
import com.example.examprojectrestapi.dto.response.GroupResponse;
import com.example.examprojectrestapi.model.Course;
import com.example.examprojectrestapi.model.Group;
import com.example.examprojectrestapi.model.Instructor;
import com.example.examprojectrestapi.repository.CourseRepository;
import com.example.examprojectrestapi.repository.GroupRepository;
import com.example.examprojectrestapi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final GroupConverterRequest groupConverterRequest;
    private final GroupConverterResponse groupConverterResponse;

    @Override
    public List<GroupResponse> getAllGroup() {
        return groupConverterResponse.getAll(groupRepository.findAll());
    }

    @Override
    public List<GroupResponse> getAllGroupById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return groupConverterResponse.getAll(course.getGroups());
    }

    @Override
    public GroupResponse getGroupById(Long groupId) {
        return groupConverterResponse.create(groupRepository.findById(groupId).get());
    }

    @Override
    public GroupResponse saveGroup(Long courseId, GroupRequest groupRequest) {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupConverterRequest.create(groupRequest);
        course.addGroup(group);
        group.addCourse(course);
        groupRepository.save(group);
        return groupConverterResponse.create(group);
    }

    @Override
    public GroupResponse updateGroup(Long groupId, GroupRequest groupRequest) {
        Group group = groupRepository.findById(groupId).get();
        groupConverterRequest.update(group, groupRequest);
        return groupConverterResponse.create(groupRepository.save(group));
    }

    @Override
    public GroupResponse deleteGroup(Long courseId, Long groupId) {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupRepository.findById(groupId).get();
        for (Course c : group.getCourses()) {
            c.getCompany().minus();
        }
        for (Course c : group.getCourses()) {
            for (Instructor i : c.getInstructors()) {
                i.minus();
            }
        }
        groupRepository.delete(group);
        return groupConverterResponse.create(group);
    }

    @Override
    public GroupResponse assignGroup(Long courseId, Long groupId) throws IOException {
        Group group = groupRepository.findById(groupId).get();
        Course course = courseRepository.findById(courseId).get();
        if (course.getGroups() != null) {
            for (Group g : course.getGroups()) {
                if (g.getId() == groupId) {
                    throw new IOException("This group already exists!");
                }
            }
        }
        group.addCourse(course);
        course.addGroup(group);
        courseRepository.save(course);
        groupRepository.save(group);
        return groupConverterResponse.create(group);
    }

}
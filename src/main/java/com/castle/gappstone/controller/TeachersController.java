package com.castle.gappstone.controller;

import com.castle.gappstone.domain.model.Teacher;
import com.castle.gappstone.domain.service.TeacherService;
import com.castle.gappstone.resource.SaveTeacherResource;
import com.castle.gappstone.resource.TeacherResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TeachersController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public Page<TeacherService> getAllTeachers(Pageable pageable) {
        Page<Teacher> teacherPage = teacherService.getAllTeachers(pageable);
        List<TeacherResource> resources = teacherPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/teachers/{teachersId}")
    public TeacherResource createTeacher(@Valid @RequestBody SaveTeacherResource resource) {
        Teacher teacher = convertToEntity(resource);
        return convertToResource(teacherService.createTeacher(teacher));
    }

    @PutMapping("/teachers/{teachersId}")
    public TeacherResource updateTeacher(@PathVariable Long teachersId, @Valid @RequestBody SaveTeacherResource resource) {
        Teacher teacher = convertToEntity(resource);
        return convertToResource(teacherService.updateTeacher(teachersId, teacher));
    }


    @DeleteMapping("/teachers/{teachersId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long teachersId) {
        return teacherService.deleteTeacher(teachersId);
    }

    private Teacher convertToEntity(SaveTeacherResource resource) {
        return mapper.map(resource, Teacher.class);
    }

    private TeacherResource convertToResource(Teacher entity) {
        return mapper.map(entity, TeacherResource.class);
    }
}
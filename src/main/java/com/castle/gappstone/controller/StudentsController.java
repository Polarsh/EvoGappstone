package com.castle.gappstone.controller;


import com.castle.gappstone.domain.model.Student;
import com.castle.gappstone.domain.service.StudentService;
import com.castle.gappstone.resource.SaveStudentResource;
import com.castle.gappstone.resource.StudentResource;
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
public class StudentsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Page<StudentService> getAllStudents(Pageable pageable) {
        Page<Student> studentPage = studentService.getAllStudents(pageable);
        List<StudentResource> resources = studentPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/students/{studentsId}")
    public StudentResource createStudent(@Valid @RequestBody SaveStudentResource resource) {
        Student student = convertToEntity(resource);
        return convertToResource(studentService.createStudent(student));
    }

    @PutMapping("/students/{studentsId}")
    public StudentResource updateStudent(@PathVariable Long studentId, @Valid @RequestBody SaveStudentResource resource) {
        Student student = convertToEntity(resource);
        return convertToResource(studentService.updateStudent(studentId, student));
    }


    @DeleteMapping("/students/{studentsId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    private Student convertToEntity(SaveStudentResource resource) {
        return mapper.map(resource, Student.class);
    }

    private StudentResource convertToResource(Student entity) {
        return mapper.map(entity, StudentResource.class);
    }
}

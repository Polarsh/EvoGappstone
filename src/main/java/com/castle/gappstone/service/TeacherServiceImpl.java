package com.castle.gappstone.service;

import com.castle.gappstone.domain.model.Teacher;
import com.castle.gappstone.domain.repository.TeacherRepository;
import com.castle.gappstone.domain.service.TeacherService;
import com.castle.gappstone.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public Page<Teacher> getAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "Id", teacherId));
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long teacherId, Teacher teacherRequest) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "Id", teacherId));
        return teacherRepository.save(
                teacher.setName(teacherRequest.getName())
                        .setEmail(teacherRequest.getEmail()));

    }

    @Override
    public ResponseEntity<?> deleteTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "Id", teacherId));
        teacherRepository.delete(teacher);
        return ResponseEntity.ok().build();
    }

}

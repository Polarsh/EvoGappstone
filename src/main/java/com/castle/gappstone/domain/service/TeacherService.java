package com.castle.gappstone.domain.service;

import com.castle.gappstone.domain.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TeacherService {
    Page<Teacher> getAllTeachers(Pageable pageable);
    Teacher getTeacherById(Long teacherId);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Long teacherId, Teacher teacherDetails);
    ResponseEntity<?> deleteTeacher(Long teacherId);
}

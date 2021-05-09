package com.castle.gappstone.domain.service;

import com.castle.gappstone.domain.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    Page<Student> getAllStudents(Pageable pageable);

    Student getStudentById(Long studentId);

    Student createStudent(Student student);

    Student updateStudent(Long studentId, Student studentDetails);

    ResponseEntity<?> deleteStudent(Long studentId);

}

package com.saquib.StudentManagement.service;

import com.saquib.StudentManagement.exception.StudentNotFoundException;
import com.saquib.StudentManagement.model.Student;
import com.saquib.StudentManagement.repo.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public Student addOrUpdateStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElseThrow(()->new StudentNotFoundException(id));
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    public List<Student> searchStudentByKeyword(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }
}

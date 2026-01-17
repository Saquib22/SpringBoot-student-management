package com.saquib.StudentManagement.controller;

import com.saquib.StudentManagement.model.Student;
import com.saquib.StudentManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;
    @PostMapping("/student")
    public ResponseEntity<Student> addStduent(@Valid @RequestBody Student student){
        Student savedStudent = service.addOrUpdateStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudent = service.getAllStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable int id){
        student.setId(id);
        Student updatedStudent = service.addOrUpdateStudent(student);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = service.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
            service.deleteStudent(id);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
    @GetMapping("/studentByKeyword")
    public ResponseEntity<List<Student>> searchStudentByKeyword(@RequestParam String keyword){
        List<Student> studentList = service.searchStudentByKeyword(keyword);
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
}

package com.saquib.StudentManagement.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(int id){
        super("Student not found with id: "+id);
    }
}

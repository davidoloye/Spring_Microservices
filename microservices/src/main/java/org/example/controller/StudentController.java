package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.StudentRequest;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createStudent(@RequestBody StudentRequest studentRequest){
        service.createStudent(studentRequest);
    }

}

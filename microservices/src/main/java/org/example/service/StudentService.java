package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.StudentRequest;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(StudentRequest studentRequest){
        Student student = new Student();
                student.setEmail(studentRequest.getEmail());
                        student.setFirstName(studentRequest.getFirstName());
                        student.setLastName(studentRequest.getLastName());
                        student.setAddress(studentRequest.getAddress());
                        student.setGender(studentRequest.getGender());
                        student.setFavouriteSubjects(studentRequest.getFavouriteSubjects());
                        student.setTotalSpentInBooks(studentRequest.getTotalSpentInBooks());
                        student.setCreate(studentRequest.getCreate());
        studentRepository.save(student);
    }
}

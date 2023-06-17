package org.example;

import org.example.model.Address;
import org.example.model.Gender;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
        return  args -> {
            Address address = new Address(
                    "Canada",
                    "4258033",
                    "New Brunswick"
            );
            String email = "davidcode@gmail.com";
            Student student = new Student(
                    "Oluwatomi",
                    "Oloye",
                    email,
                    Gender.MALE,
                    address,
                    Arrays.asList("Test Coding", "Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now());

            repository.findStudentByEmail(email).ifPresent(student1 -> {
                System.out.println(" ::: Student Already Exist::::" + student);
            });




        };
    }


    private void UsingMongoeTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = mongoTemplate.find(query, Student.class);

        if(students.size() > 1){
            throw new IllegalStateException(" :::::: found many students with email :::: " + student.getEmail());
        }
        if(students.isEmpty()){
            System.out.println("::::: Inserting Students ::: " + student);
            repository.insert(student);
        }
        else {
            System.out.println(" ::: Student Already Exist::::" + student);
        }
    }
}
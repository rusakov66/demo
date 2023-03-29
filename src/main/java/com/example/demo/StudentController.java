package com.example.demo;

import com.example.demo.entities.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repo;


    @GetMapping(value = "/students")
    public void getAllStudents() {
       Student student = new Student();
       student.setName("Test");
       student.setAge(40);

       repo.save(student);

       int result = repo.findByName("Test");
       System.out.println(result);

    }


}

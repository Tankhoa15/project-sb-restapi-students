package com.ntkhoa.restapi.controller;

import com.ntkhoa.restapi.entity.Student;
import com.ntkhoa.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    //getallstudents
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    // get student by id
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student student = repo.findById(id).get();
        return student;
    }

    //create student
    @PostMapping("/student/add")
    public void createStudent(@RequestBody Student student) {
        repo.save(student);
    }

    //update student
    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student student1 = repo.findById(id).get();
        student1.setName(student.getName());
        student1.setPercentage(student.getPercentage());
        student1.setBranch(student.getBranch());
        repo.save(student1);
        return student1;
    }

    //delete student
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        repo.delete(student);
    }
}

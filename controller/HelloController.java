package org.example.lastjwt.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.lastjwt.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Sova", 69),
            new Student(2, "Reyna", 23)
    )
    );

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello" + " " + request.getSession().getId();
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student) {
        students.add(student);
        return student;
    }
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

}

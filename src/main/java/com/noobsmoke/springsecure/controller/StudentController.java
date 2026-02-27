package com.noobsmoke.springsecure.controller;

import com.noobsmoke.springsecure.model.Student;
import com.noobsmoke.springsecure.repository.FakeRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@AllArgsConstructor
public class StudentController {

    private final FakeRepo fakeRepo;


    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(fakeRepo.getAllStudents());
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
        fakeRepo.addNewStudent(student);
        return ResponseEntity.ok(student.getName() + " Has Been Added To List");
    }
}

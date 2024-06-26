package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
       return studentService.addStudent(student);
    }

    @PostMapping("all")
    public List<Student> addStudents(@Valid @RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }

    @PutMapping
    public void editStudent(@Valid @RequestBody Student student) {
        studentService.editStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}

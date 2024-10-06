package com.project2.CRUD_Using_MongoDB.Controller;

import com.project2.CRUD_Using_MongoDB.Model.Student;
import com.project2.CRUD_Using_MongoDB.Repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // Create a new student
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return "Student added with ID: " + student.getId();
    }

    // Get all students
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Get a student by ID
    @GetMapping("/get/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) {
        return studentRepo.findById(id);
    }

    // Update a student by ID
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        return studentRepo.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setDepartment(updatedStudent.getDepartment());
            studentRepo.save(student);
            return "Student updated successfully!";
        }).orElseGet(() -> "Student not found with ID: " + id);
    }

    // Delete a student by ID
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentRepo.deleteById(id);
        return "Student deleted with ID: " + id;
    }
}

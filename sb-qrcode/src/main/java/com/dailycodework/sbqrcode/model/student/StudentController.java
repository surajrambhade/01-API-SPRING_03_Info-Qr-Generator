package com.dailycodework.sbqrcode.model.student;

import com.dailycodework.sbqrcode.utils.QRCodeGenrater;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServices studentServices;

    @GetMapping("")
    public ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {

        List<Student> students = studentServices.getStudent();
        if (students.size() != 0) {
            for (Student student: students) {
                QRCodeGenrater.generateQRCode(student);
            }
        }

        return ResponseEntity.ok(studentServices.getStudent());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentServices.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") Long id){
        return studentServices.findById(id);
    }

//http://localhost:9192/students/1 - get by id
// http://localhost:9192/students  - get all 
}

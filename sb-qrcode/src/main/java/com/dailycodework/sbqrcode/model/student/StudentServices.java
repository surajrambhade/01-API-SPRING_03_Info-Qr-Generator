package com.dailycodework.sbqrcode.model.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices {


    private final StudentRepository studentRepository;

    public List<Student> getStudent(){

        return studentRepository.findAll();
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Steudent Not Found!"));
    }
}

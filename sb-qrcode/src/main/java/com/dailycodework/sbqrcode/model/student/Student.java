package com.dailycodework.sbqrcode.model.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstName;
    private String SecondName;
    private String email;
    private Integer mobile;

    public Student(String name, String firstName, String secondName, String email, Integer mobile) {
        this.name = name;
        this.firstName = firstName;
        SecondName = secondName;
        this.email = email;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                '}';
    }

}

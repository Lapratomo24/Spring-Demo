package com.wildcodeschool.springDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Autowired
    public List<Student> getStudents() {
        return studentRepo.findAll();
//        return List.of(
//                new Student(
//                        1L,
//                        "Brian",
//                        20,
//                        LocalDate.of(2000, Month.APRIL, 20),
//                        "brian.fury@outlook.com"
//                )
//        );
    }

}

package com.wildcodeschool.springDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepo.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepo.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist."
            );
        }
        studentRepo.deleteById(studentId);
    }



}
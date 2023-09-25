package com.wildcodeschool.springDemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args -> {
            Student layla = new Student(
                    "Layla",
                    LocalDate.of(1992, Month.APRIL, 30),
                    "layla.hussain@gmail.com"
            );

            Student michael = new Student(
                    "Michael",
                    LocalDate.of(1994, Month.APRIL, 14),
                    "michael.renner@gmail.com"
            );

            repo.saveAll(
                    List.of(layla, michael)
            );
        };
    }

}

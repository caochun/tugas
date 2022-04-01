package com.example.tugas;

import com.example.tugas.model.Employee;
import com.example.tugas.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TugasApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TugasApplication.class, args);
    }

    private final EmployeeRepository repository;

    @Autowired
    public TugasApplication(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
    }

}

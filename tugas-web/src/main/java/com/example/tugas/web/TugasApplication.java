package com.example.tugas.web;

import com.example.tugas.employee.Employee;
import com.example.tugas.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.tugas"})
@EntityScan("com.example.tugas.employee")
@EnableJpaRepositories("com.example.tugas.employee")
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

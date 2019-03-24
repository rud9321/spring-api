package com.example.code.mongoapp.dbcontext;

import java.util.Arrays;
import java.util.List;

import com.example.code.mongoapp.models.Student;
import com.example.code.mongoapp.repositories.IStudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * DbSeeder
 * 
 * This is only for putting data for testing purpose, For development only After
 * you can delete this class
 */

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private IStudentRepository Irepository;

    public DbSeeder(IStudentRepository iStudentRepository) {
        this.Irepository = iStudentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Student student1 = new Student("Rudra", "Singh", 27, "MV-1");
        Student student2 = new Student("Jaina", null, 26, "UP");
        List<Student> students = Arrays.asList(student1, student2);

        this.Irepository.deleteAll();
        this.Irepository.saveAll(students);
    }

}
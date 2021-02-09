package com.Aleksandar.student.dal;

import com.Aleksandar.student.dal.entities.Student;
import com.Aleksandar.student.dal.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("John");
        student.setCourse("Java Web Services");
        student.setFee(30d);
        studentRepository.save(student);
    }

    @Test
    public void testFindStudentById() {
        Optional<Student> byId = studentRepository.findById(1L);

        System.out.println(byId.toString());

    }

    @Test
    public void testUpdateStudent() {
        Student byId = studentRepository.findById(1L).get();

        byId.setFee(40d);

        studentRepository.save(byId);

    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        student.setId(2L);
        studentRepository.delete(student);


    }
}

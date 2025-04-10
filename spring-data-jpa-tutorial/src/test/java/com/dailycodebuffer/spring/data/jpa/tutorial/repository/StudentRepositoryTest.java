package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    private Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryTest.class);

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("qwe@gmail.com")
                .firstName("qwe")
                .lastName("rty")
//                .guardianName("asdf")
//                .guardianEmail("asd@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
//        students.forEach(System.out::println);
        System.out.println("Student count: " + students);
    }


    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("asd")
                .email("asd@gmail.com")
                .mobileNumber("9999999999")
                .build();

        Student student = Student.builder()
                .emailId("qwe2@gmail.com")
                .firstName("qwe")
                .lastName("rty")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("qwe");
        LOGGER.info("Student Details :"+ students);
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("q");

        LOGGER.info("Students : " + students);
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student students = studentRepository.getStudentByEmailAddress("qwe@gmail.com");

        LOGGER.info("Students : " + students);
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student students = studentRepository.getStudentByEmailAddressNative("qwe@gmail.com");

        LOGGER.info("Students : " + students);
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student students = studentRepository.getStudentByEmailAddressNativeNamedParams("qwe@gmail.com");

        LOGGER.info("Students : " + students);
        System.out.println("Students : " + students);
    }

    @Test
    public void updaateStudentNameByEmailId(){
        studentRepository.updaateStudentNameByEmailId("asdf","qwe@gmail.com");
    }


}
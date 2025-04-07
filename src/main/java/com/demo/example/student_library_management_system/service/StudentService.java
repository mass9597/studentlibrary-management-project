package com.demo.example.student_library_management_system.service;


import com.demo.example.student_library_management_system.convertor.StudentConvertor;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        //first convert the dto to modelclass

        Student student = StudentConvertor.convertDtoStudent(studentRequestDto);


        //whenever you enroll a new student, a card should be created for each student (cascade)
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);
        card.setBloodGroup(studentRequestDto.getBloodGroup());

        student.setCard(card);
        studentRepository.save(student);

        return "Student and card are saved successfully";
    }

    public List<Student> findStudents(){
       List<Student> studentList =  studentRepository.findAll();

       return studentList;
    }
}

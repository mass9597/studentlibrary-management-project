package com.demo.example.student_library_management_system.service;


import com.demo.example.student_library_management_system.convertor.StudentConvertor;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Student findIndividualById(int id){

        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.get();

    }

    public String modifyById(int id, StudentRequestDto studentRequestDto){

        Student student = findIndividualById(id);

        if(student !=null){
            student.setName(studentRequestDto.getName());
            student.setMobile(studentRequestDto.getMobile());
            student.setAddress(studentRequestDto.getAddress());
            student.setDob(studentRequestDto.getDob());
            student.setEmail(studentRequestDto.getEmail());
            student.setGender(studentRequestDto.getGender());
            student.setSem(studentRequestDto.getSem());
            student.setSection(studentRequestDto.getSection());
            student.setDept(studentRequestDto.getDept());

            studentRepository.save(student);

            return "Student details updated successfully";
        }else{
            return "cannot update the details as there is no student exists with this id: "+id;
        }
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student removed from DB";
    }

    //pagenation - it is the process of converting the larger data to smaller one, manageable pages

    public List<Student> pagenation(int pageNo, int pageSize,String sortBy, String order){


       if(order.equalsIgnoreCase("ascending")){
           List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize,Sort.by(sortBy).ascending())).getContent();

       }
       List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize,Sort.by(sortBy).descending())).getContent();

               return studentList;
    }

    public List<Student> getAllStudentByDept(@RequestParam String dept){
        List<Student> studentList = studentRepository.getAllStudentByDept(dept,PageRequest.of(0,1));
        return studentList;
    }


}

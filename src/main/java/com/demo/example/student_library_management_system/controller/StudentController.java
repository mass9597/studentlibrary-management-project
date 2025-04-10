package com.demo.example.student_library_management_system.controller;


import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")

public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){

        String response = studentService.addStudent(studentRequestDto);

        return response;
    }

    @GetMapping("/findAll")

    public List<Student> findAllStudent(){
          List<Student> studentList = studentService.findStudents();

          return studentList;
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){

        try {
            Student student = studentService.findIndividualById(id);
            return ResponseEntity.ok(student);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("student with id :"+" "+id+" "+"doesn't exist in database");

        }

    }

    @PutMapping("/update/{id}")

    public String updateById(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
          String response = studentService.modifyById(id,studentRequestDto);
          return response;
    }

    @DeleteMapping("/delete/{id}")

    public String deleteById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;

    }

    @GetMapping("/pagenation")

    /* ResponseEntity - it is a representation of http responses including the status code, header and body
     <?> - it is a wildcard, indicates the type of response is generic
     */

    public ResponseEntity<?> findAndPagenation(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam String sortBy,@RequestParam String order){
        List<Student> studentList = studentService.pagenation(pageNo,pageSize,sortBy,order);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping ("/findByDept")
    public ResponseEntity<?> findById(@RequestParam String dept){

        try {
            List<Student> studentList = studentService.getAllStudentByDept(dept);
            return ResponseEntity.ok(studentList);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("No students with dept :"+" "+dept+" "+"doesn't exist in database");

        }

    }





}

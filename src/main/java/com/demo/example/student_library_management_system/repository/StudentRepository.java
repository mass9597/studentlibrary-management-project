package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.Student;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
   /* writing our own customized query
    using JPA hibernate
    findBy - this keyword is must in the menthod name as it is inbuilt in jpa

    */

    public List<Student> findByEmail(String email, Pageable pageable);

   // writing SQL query

    @Query(nativeQuery = true, value = "SELECT * FROM student where dept = :dept1")
    public List<Student> getAllStudentByDept(String dept1, Pageable pageable);
}

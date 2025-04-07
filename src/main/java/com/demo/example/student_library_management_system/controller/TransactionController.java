package com.demo.example.student_library_management_system.controller;


import com.demo.example.student_library_management_system.convertor.TransactionConvertor;
import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;
import com.demo.example.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/apis")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){

        String response = transactionService.addTransaction(transactionRequestDto);

        return response;
    }
}

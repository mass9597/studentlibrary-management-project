package com.demo.example.student_library_management_system.convertor;

import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConvertor {

    public static Transaction convertDtoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = new Transaction();

        transaction.setFine(transactionRequestDto.getFine());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setTransactionType(transactionRequestDto.getTransactionType());

        return transaction;
    }
}

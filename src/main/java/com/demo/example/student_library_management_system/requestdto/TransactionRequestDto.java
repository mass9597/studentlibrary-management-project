package com.demo.example.student_library_management_system.requestdto;

import com.demo.example.student_library_management_system.enums.TransactionType;


public class TransactionRequestDto {

    private double fine;
    private String dueDate;
    private TransactionType transactionType;


    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}

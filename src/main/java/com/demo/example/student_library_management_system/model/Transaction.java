package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    @Column(name="transaction_date",nullable = false)
    private Date transactionDate;

    @Column(name="fine")
    private double fine;

    @Column(name="due_date",nullable = false)
    private String dueDate;

    @Column(name="transaction_type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "card_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;

}

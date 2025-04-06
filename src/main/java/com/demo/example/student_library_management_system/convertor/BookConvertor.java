package com.demo.example.student_library_management_system.convertor;

import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConvertor {

    public static Book convertDtoBook(BookRequestDto bookRequestDto){
        Book book = new Book();

        book.setEdition(bookRequestDto.getEdition());
        book.setPrice(bookRequestDto.getPrice());
        book.setPages(bookRequestDto.getPages());
        book.setCategory(bookRequestDto.getCategory());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setRackNo(bookRequestDto.getRackNo());
        book.setTitle(bookRequestDto.getTitle());

        return book;
    }
}

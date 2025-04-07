package com.demo.example.student_library_management_system.service;


import com.demo.example.student_library_management_system.convertor.BookConvertor;
import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.repository.AuthorRepository;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CardRepository cardRepository;

    public String addBook(BookRequestDto bookRequestDto){
        Book book = BookConvertor.convertDtoBook(bookRequestDto);

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

        if(author == null){
            book.setAuthor(null);
        }
        book.setAuthor(author);

        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();

        if(card == null){
            book.setCard(null);
        }

        book.setCard(card);


        bookRepository.save(book);

        return "Book details saved successfully";
    }
}

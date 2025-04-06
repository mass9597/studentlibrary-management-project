package com.demo.example.student_library_management_system.convertor;

//convertor - is used to convert the object of requestdto class to model class

import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.requestdto.AuthorRequestDto;

public class AuthorConvertor {

    public static Author convertDtoAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();

        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setRating(authorRequestDto.getRating());
        author.setCountry(authorRequestDto.getCountry());

        return author;
    }


}

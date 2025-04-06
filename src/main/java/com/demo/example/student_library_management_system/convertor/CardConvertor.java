package com.demo.example.student_library_management_system.convertor;

import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.requestdto.CardRequestDto;

public class CardConvertor {

    public static Card convertDtoCard(CardRequestDto cardRequestDto){
        Card card = new Card();

        card.setCardStatus(cardRequestDto.getCardStatus());
        card.setBloodGroup(cardRequestDto.getBloodGroup());

        return card;
    }
}

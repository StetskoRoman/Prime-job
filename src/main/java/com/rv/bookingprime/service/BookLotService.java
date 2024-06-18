package com.rv.bookingprime.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rv.bookingprime.dto.BookLotRequest;
import com.rv.bookingprime.entity.BookLot;
import com.rv.bookingprime.entity.Lot;
import com.rv.bookingprime.exception.LotNotFoundException;
import com.rv.bookingprime.repos.BookLotRepo;
import com.rv.bookingprime.repos.LotRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookLotService {


    private final BookLotRepo bookLotRepo;
    private final LotRepo lotRepo;

    public String addBookLot(BookLotRequest bookLotRequest) {

        log.info("adding book lot");
        Lot lot = lotRepo.findById(bookLotRequest.getLotId()).orElseThrow(() -> new LotNotFoundException());
        BookLot bookLot = bookLotRepo.findBookLotByPhoneNumberAndLot(bookLotRequest.getPhoneNumber(), lot)
                .orElse(BookLot.builder()
                .fio(bookLotRequest.getFio())
                .localDateTime(LocalDateTime.now())
                .phoneNumber(bookLotRequest.getPhoneNumber())
                .lot(lot)
                .build());
        bookLotRepo.save(bookLot);

        log.info("bookLot: {}", bookLot);
        return "successfully booked";
    }
}


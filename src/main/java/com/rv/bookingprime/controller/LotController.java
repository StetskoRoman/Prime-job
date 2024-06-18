package com.rv.bookingprime.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rv.bookingprime.dto.BookLotRequest;
import com.rv.bookingprime.dto.LotFilterDto;
import com.rv.bookingprime.dto.LotResponse;
import com.rv.bookingprime.service.BookLotService;
import com.rv.bookingprime.service.LotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LotController {

    private final LotService lotService;
    private final BookLotService bookLotService;

    @GetMapping("/lots")
    public ResponseEntity<List<LotResponse>> getAllLotsWithFilter(@RequestBody LotFilterDto lotFilterDto) {
        log.info("getAllLotsWithFilter in controller");
        return new ResponseEntity<>(lotService.findAllLotsWithFilter(lotFilterDto), HttpStatus.OK);
    }

    @PutMapping("/addLot")
    public ResponseEntity<String> addBook(@RequestBody BookLotRequest bookLotRequest) throws JsonProcessingException {
        log.info("addBook in controller");

        return new ResponseEntity<>(bookLotService.addBookLot(bookLotRequest), HttpStatus.OK);
    }
}

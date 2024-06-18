package com.rv.bookingprime.service;


import com.rv.bookingprime.dto.LotFilterDto;
import com.rv.bookingprime.dto.LotResponse;
import com.rv.bookingprime.mapper.Mapper;
import com.rv.bookingprime.repos.LotRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LotService {


    private final LotRepo lotRepo;
    private final Mapper mapper;

    public List<LotResponse> findAllLotsWithFilter(LotFilterDto lotFilterDto) {
        log.info("findAllLotsWithFilter in service");
        return lotRepo.findLotsByFilter(lotFilterDto.getName(), lotFilterDto.getMinFloor(), lotFilterDto.getMaxFloor(), lotFilterDto.getMinSquare(),
                lotFilterDto.getMaxSquare(), lotFilterDto.getMinRoom(), lotFilterDto.getMaxRoom(), lotFilterDto.getTown())
                .orElse(Collections.emptyList())
                .stream().map(mapper::toLotResponseDto).toList();

    }

}

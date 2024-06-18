package com.rv.bookingprime.mapper;

import com.rv.bookingprime.dto.LotResponse;
import com.rv.bookingprime.entity.Lot;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public LotResponse toLotResponseDto(Lot lot) {
        return LotResponse.builder()
                .lotName(lot.getLotName())
                .town(lot.getTown())
                .address(lot.getAddress())
                .square(lot.getSquare())
                .floor(lot.getFloor())
                .rooms(lot.getRooms())
                .build();
    }


}

package com.rv.bookingprime.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LotFilterDto {

    private String name;
    private Integer minFloor;
    private Integer maxFloor;
    private BigDecimal minSquare;
    private BigDecimal maxSquare;
    private Integer minRoom;
    private Integer maxRoom;
    private String town;
}

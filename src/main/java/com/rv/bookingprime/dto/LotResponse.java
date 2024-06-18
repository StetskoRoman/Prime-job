package com.rv.bookingprime.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LotResponse {

    private String lotName;
    private String town;
    private String address;
    private BigDecimal square;
    private Integer floor;
    private Integer rooms;

}

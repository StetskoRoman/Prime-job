package com.rv.bookingprime.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookLotRequest {

    @NotEmpty
    private String fio;
    @NotEmpty
    @Pattern(regexp = "\\d+", message = "Phone number must contain only digits")
    private String phoneNumber;
    @NotEmpty
    private Long lotId;

}

package com.rv.bookingprime.exception;


public class LotNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Lot not found";

    public LotNotFoundException() {
        super(MESSAGE);
    }


}

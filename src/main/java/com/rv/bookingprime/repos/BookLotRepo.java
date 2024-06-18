package com.rv.bookingprime.repos;

import com.rv.bookingprime.entity.BookLot;
import com.rv.bookingprime.entity.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookLotRepo extends JpaRepository<BookLot, Long> {

    Optional<BookLot> findBookLotByPhoneNumberAndLot(String phoneNumber, Lot lot);
}

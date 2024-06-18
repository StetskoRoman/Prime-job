package com.rv.bookingprime.repos;

import com.rv.bookingprime.entity.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface LotRepo extends JpaRepository<Lot, Long> {

    @Query("SELECT l FROM Lot l WHERE " +
            "(:name IS NULL OR l.lotName ILIKE %:name%) AND " +
            "(:minFloor IS NULL OR l.floor >= :minFloor) AND " +
            "(:maxFloor IS NULL OR l.floor <= :maxFloor) AND " +
            "(:minSquare IS NULL OR l.square >= :minSquare) AND " +
            "(:maxSquare IS NULL OR l.square <= :maxSquare) AND " +
            "(:minRoom IS NULL OR l.rooms >= :minRoom) AND " +
            "(:maxRoom IS NULL OR l.rooms <= :maxRoom) AND " +
            "(:town IS NULL OR l.town LIKE %:town%)")
    Optional<List<Lot>> findLotsByFilter(
            @Param("name") String name,
            @Param("minFloor") Integer minFloor,
            @Param("maxFloor") Integer maxFloor,
            @Param("minSquare") BigDecimal minSquare,
            @Param("maxSquare") BigDecimal maxSquare,
            @Param("minRoom") Integer minRoom,
            @Param("maxRoom") Integer maxRoom,
            @Param("town") String town);
}

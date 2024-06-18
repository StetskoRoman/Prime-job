package com.rv.bookingprime.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Lot name can`t be empty")
    private String lotName;
    private String town;
    private String address;
    private BigDecimal square;
    private Integer floor;
    private Integer rooms;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lot", orphanRemoval = true)
    private List<BookLot> bookLotList;
}


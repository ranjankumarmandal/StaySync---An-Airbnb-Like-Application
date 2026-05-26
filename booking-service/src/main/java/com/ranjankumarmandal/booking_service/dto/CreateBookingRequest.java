package com.ranjankumarmandal.booking_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateBookingRequest {

    private Long userId;

    private Long listingId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Integer guests;
}
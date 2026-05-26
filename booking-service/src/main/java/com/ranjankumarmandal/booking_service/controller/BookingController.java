package com.ranjankumarmandal.booking_service.controller;

import com.ranjankumarmandal.booking_service.dto.CreateBookingRequest;
import com.ranjankumarmandal.booking_service.entity.Booking;
import com.ranjankumarmandal.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking create(
            @RequestBody CreateBookingRequest request
    ) {

        return bookingService.create(request);
    }

    @GetMapping("/{id}")
    public Booking getById(
            @PathVariable Long id
    ) {

        return bookingService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(
            @PathVariable Long userId
    ) {

        return bookingService.getUserBookings(userId);
    }

    @PutMapping("/{id}/cancel")
    public Booking cancel(
            @PathVariable Long id
    ) {

        return bookingService.cancel(id);
    }
}
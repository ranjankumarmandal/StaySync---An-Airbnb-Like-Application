package com.ranjankumarmandal.booking_service.service;

import com.ranjankumarmandal.booking_service.dto.CreateBookingRequest;
import com.ranjankumarmandal.booking_service.entity.Booking;
import com.ranjankumarmandal.booking_service.entity.BookingStatus;
import com.ranjankumarmandal.booking_service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking create(CreateBookingRequest request) {

        boolean alreadyBooked =
                bookingRepository
                        .existsByListingIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(
                                request.getListingId(),
                                request.getCheckOutDate(),
                                request.getCheckInDate()
                        );

        if (alreadyBooked) {
            throw new RuntimeException("Listing unavailable for selected dates");
        }

        long nights = ChronoUnit.DAYS.between(
                request.getCheckInDate(),
                request.getCheckOutDate()
        );

        Booking booking = new Booking();

        booking.setUserId(request.getUserId());
        booking.setListingId(request.getListingId());
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setGuests(request.getGuests());

        // temporary static pricing
        booking.setTotalPrice(BigDecimal.valueOf(nights * 3500));

        booking.setStatus(BookingStatus.CONFIRMED);

        return bookingRepository.save(booking);
    }

    public Booking getById(Long id) {

        return bookingRepository.findById(id)
                .orElseThrow();
    }

    public List<Booking> getUserBookings(Long userId) {

        return bookingRepository.findByUserId(userId);
    }

    public Booking cancel(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow();

        booking.setStatus(BookingStatus.CANCELLED);

        return bookingRepository.save(booking);
    }
}
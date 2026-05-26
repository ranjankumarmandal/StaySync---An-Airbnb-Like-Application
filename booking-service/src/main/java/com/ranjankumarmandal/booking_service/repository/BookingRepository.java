package com.ranjankumarmandal.booking_service.repository;

import com.ranjankumarmandal.booking_service.entity.Booking;
import com.ranjankumarmandal.booking_service.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    List<Booking> findByListingId(Long listingId);

    List<Booking> findByListingIdAndStatus(
            Long listingId,
            BookingStatus status
    );

    boolean existsByListingIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(
            Long listingId,
            LocalDate checkOutDate,
            LocalDate checkInDate
    );
}
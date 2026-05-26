package com.ranjankumarmandal.payment_service.controller;

import com.ranjankumarmandal.payment_service.dto.CreatePaymentRequest;
import com.ranjankumarmandal.payment_service.entity.Payment;
import com.ranjankumarmandal.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment create(
            @RequestBody CreatePaymentRequest request
    ) {

        return paymentService.create(request);
    }

    @GetMapping("/{id}")
    public Payment getById(
            @PathVariable Long id
    ) {

        return paymentService.getById(id);
    }

    @GetMapping("/booking/{bookingId}")
    public List<Payment> getByBooking(
            @PathVariable Long bookingId
    ) {

        return paymentService.getByBooking(bookingId);
    }

    @PutMapping("/{id}/refund")
    public Payment refund(
            @PathVariable Long id
    ) {

        return paymentService.refund(id);
    }
}
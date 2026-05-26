package com.ranjankumarmandal.payment_service.service;

import com.ranjankumarmandal.payment_service.dto.CreatePaymentRequest;
import com.ranjankumarmandal.payment_service.entity.Payment;
import com.ranjankumarmandal.payment_service.entity.PaymentStatus;
import com.ranjankumarmandal.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment create(CreatePaymentRequest request) {

        Payment payment = new Payment();

        payment.setBookingId(request.getBookingId());
        payment.setUserId(request.getUserId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());

        // mock transaction success
        payment.setStatus(PaymentStatus.SUCCESS);

        payment.setTransactionId(UUID.randomUUID().toString());

        return paymentRepository.save(payment);
    }

    public Payment getById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow();
    }

    public List<Payment> getByBooking(Long bookingId) {

        return paymentRepository.findByBookingId(bookingId);
    }

    public Payment refund(Long id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow();

        payment.setStatus(PaymentStatus.REFUNDED);

        return paymentRepository.save(payment);
    }
}
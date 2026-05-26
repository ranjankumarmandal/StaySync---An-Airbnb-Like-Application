package com.ranjankumarmandal.payment_service.dto;

import com.ranjankumarmandal.payment_service.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreatePaymentRequest {

    private Long bookingId;

    private Long userId;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;
}
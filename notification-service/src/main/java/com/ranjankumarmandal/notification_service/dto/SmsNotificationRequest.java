package com.ranjankumarmandal.notification_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsNotificationRequest {

    private String phoneNumber;

    private String message;
}
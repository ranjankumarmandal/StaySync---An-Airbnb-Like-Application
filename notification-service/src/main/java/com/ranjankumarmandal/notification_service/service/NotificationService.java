package com.ranjankumarmandal.notification_service.service;

import com.ranjankumarmandal.notification_service.dto.EmailNotificationRequest;
import com.ranjankumarmandal.notification_service.dto.SmsNotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String sendEmail(
            EmailNotificationRequest request
    ) {

        return "Email sent to " + request.getTo();
    }

    public String sendSms(
            SmsNotificationRequest request
    ) {

        return "SMS sent to " + request.getPhoneNumber();
    }
}
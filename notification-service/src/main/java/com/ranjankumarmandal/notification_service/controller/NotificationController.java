package com.ranjankumarmandal.notification_service.controller;

import com.ranjankumarmandal.notification_service.dto.EmailNotificationRequest;
import com.ranjankumarmandal.notification_service.dto.SmsNotificationRequest;
import com.ranjankumarmandal.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/email")
    public String sendEmail(
            @RequestBody EmailNotificationRequest request
    ) {

        return notificationService.sendEmail(request);
    }

    @PostMapping("/sms")
    public String sendSms(
            @RequestBody SmsNotificationRequest request
    ) {

        return notificationService.sendSms(request);
    }
}
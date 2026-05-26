package com.ranjankumarmandal.notification_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailNotificationRequest {

    private String to;

    private String subject;

    private String message;
}
package com.henrique.MailNotification.service;

import com.henrique.MailNotification.dto.mailNotificationDto.MailMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class EmailListenerService {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "mail-sender", groupId = "mail-notification-group")
    public void listen(String message) {
        MailMessageDto mailMessage = objectMapper.readValue(message, MailMessageDto.class);
        emailService.emailSender(mailMessage);
    }
}

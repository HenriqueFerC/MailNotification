package com.henrique.MailNotification.dto.mailNotificationDto;

import java.math.BigDecimal;

public record MailMessageDto(String payerFullName, String payeeFullName, String payeeEmail, BigDecimal amount) {
}

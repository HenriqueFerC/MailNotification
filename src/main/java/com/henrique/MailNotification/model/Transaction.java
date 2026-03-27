package com.henrique.MailNotification.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Transaction {
    private Integer id;

    private BigDecimal value;

    private User payer;

    private User payee;

    private LocalDateTime transactionDate;

    private TransactionType transactionType;

    private Consistency consistency;
}

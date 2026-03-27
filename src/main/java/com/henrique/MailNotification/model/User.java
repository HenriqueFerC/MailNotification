package com.henrique.MailNotification.model;

import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private Integer id;

    private String fullName;

    private String cpfCnpj;

    private String email;

    private String password;

    private UserType userType;

    private List<Transaction> transactions;
}

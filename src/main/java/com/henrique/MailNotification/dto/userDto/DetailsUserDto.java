package com.henrique.MailNotification.dto.userDto;


import com.henrique.MailNotification.model.User;
import com.henrique.MailNotification.model.UserType;

public record DetailsUserDto(Integer id, String fullName, String cpfCnpj, String email, UserType userType) {
    public DetailsUserDto(User user) {
        this(user.getId(), user.getFullName(), user.getCpfCnpj(), user.getEmail(), user.getUserType());
    }
}

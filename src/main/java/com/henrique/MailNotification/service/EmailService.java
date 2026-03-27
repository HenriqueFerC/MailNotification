package com.henrique.MailNotification.service;

import com.henrique.MailNotification.dto.transactionDto.DetailsTransactionDto;
import com.henrique.MailNotification.exceptions.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Value("${email.host}")
    public String from;

    @Value("${email.sender.name}")
    private String senderName;

    public void emailSender(DetailsTransactionDto transactionDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(new InternetAddress(from, senderName));
            mimeMessageHelper.setTo(InternetAddress.parse(transactionDto.payee().email()));
            mimeMessageHelper.setSubject("Notificação de transferência");

            Context context = new Context();
            context.setVariable("payeeName", transactionDto.payee().fullName());
            context.setVariable("amount", transactionDto.value());
            context.setVariable("senderName", transactionDto.payer().fullName());
            String template = templateEngine.process("notification", context);
            mimeMessageHelper.setText(template, true);
            javaMailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException("Erro ao enviar email.", e.getCause());
        }
    }
}

package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.domain.Mail;
import com.BfDmichal.tradingplatform.exception.UserNotFundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail) throws MailException {
        try {
            javaMailSender.send(createMail(mail));
        } catch (MessagingException e) {
            throw new MailException("Mail has not send. Something went wrong.") {
            };
        }
    }

    private SimpleMailMessage createMail(final Mail mail) throws MessagingException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail.getMailTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMassage());
        return simpleMailMessage;
    }
}

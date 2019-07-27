package com.example.customermicroservice.service;

import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

        private JavaMailSender javaMailSender;

        @Autowired
        public NotificationService(JavaMailSender javaMailSender)
        {
            this.javaMailSender=javaMailSender;
        }

        public void sendNotifcation()throws MailException
        {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setTo("sidana1997@gmail.com");
            simpleMailMessage.setFrom("cmpnvijay@gmail.com");
            simpleMailMessage.setSubject("Hello");
            simpleMailMessage.setText("Hllo");

            javaMailSender.send(simpleMailMessage);
        }
}

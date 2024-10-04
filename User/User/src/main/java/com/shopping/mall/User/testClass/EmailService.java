//package com.shopping.mall.User.testClass;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService implements CommandLineRunner {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Override
//    public void run(String... args) {
//        System.out.println("Sending Email...");
//
//
//        String[] recipients = {"rugvedk1803@gmail.com", "1dt21is120@dsatm.edu.in"};
//        String subject = "Dynamic Subject - Testing Email Service";
//        String text = "Hello, this is a test email from Spring Boot Email Service.";
//
//        sendSimpleEmail(recipients, subject, text);
//
//        System.out.println("Done");
//    }
//
//    public void sendSimpleEmail(String[] recipients, String subject, String text) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(recipients);
//        msg.setSubject(subject);
//        msg.setText(text);
//
//        javaMailSender.send(msg);
//    }
//}

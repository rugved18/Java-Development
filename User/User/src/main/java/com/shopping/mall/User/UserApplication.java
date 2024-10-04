package com.shopping.mall.User;

import com.shopping.mall.User.testClass.ValueCheck;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.IOException;

@SpringBootApplication
public class UserApplication implements CommandLineRunner  {

	public ValueCheck valueCheck;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	public UserApplication(ValueCheck valueCheck) {
		this.valueCheck = valueCheck;
	}

	@Override
	public void run(String... args) throws Exception {
		valueCheck.test();
	}
}

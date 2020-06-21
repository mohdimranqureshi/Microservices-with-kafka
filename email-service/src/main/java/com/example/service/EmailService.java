package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.exampe.dto.UserDTO;
import com.example.entity.Mail;
import com.example.repository.MailRepository;

@Component
public class EmailService {

	@Autowired
	JavaMailSender emailSender;

	@Autowired
	MailRepository mailRepository;

	public void sendEmail(UserDTO user) {
		try {
			Mail newMail = new Mail();
			newMail.setTo(user.getUsername());
			newMail.setSubject("TestSubject");
			newMail.setText("TestText");

			SimpleMailMessage message = new SimpleMailMessage();
			message.setText(newMail.getTo());
			message.setSubject(newMail.getSubject());
			message.setText(newMail.getText());

			mailRepository.save(newMail);
			emailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}
	}
}

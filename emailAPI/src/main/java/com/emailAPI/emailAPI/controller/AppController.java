package com.emailAPI.emailAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private JavaMailSender mailSender;


	@PostMapping("/send_text_email")
	
	public String sendPlainTextEmail(@RequestParam("fromEmail") String fromEmail,
			@RequestParam("toEmail") String toEmail) {

		String from = fromEmail;
		String to = toEmail;
		//System.out.println("from-email---" + from);
		//System.out.println("to--email-" + to);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("This is a plain text email");
		message.setText("Hello guys! This is a plain text email.");

		mailSender.send(message);

		return "result";
	}

}

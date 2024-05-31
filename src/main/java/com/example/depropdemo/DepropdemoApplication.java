package com.example.depropdemo;

import com.example.depropdemo.mail.BillConfirm;
import com.example.depropdemo.mail.GmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DepropdemoApplication implements CommandLineRunner {
	@Autowired
	private GmailSender sender;
	public static void main(String[] args) {
		SpringApplication.run(DepropdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		sender.send(BillConfirm.getTemplete(" thaideptrai"), "tn102341@gmail.com");
	}
}

package com.example.springencryption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringEncryptionApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringEncryptionApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);
		User user = new User(null, "felipe", "contraseniaFuertejaja");
		repository.save(user);
	}
}

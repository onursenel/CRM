package com.etiya.customerservice;

import com.etiya.common.business.abstracts.MessageService;
import com.etiya.common.business.concretes.MessageServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	public MessageService getMessageService(MessageSource messageSource){
		return new MessageServiceImpl(messageSource);
	}


}

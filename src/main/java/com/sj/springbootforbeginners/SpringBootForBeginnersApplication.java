package com.sj.springbootforbeginners;

//import com.sj.springbootforbeginners.service.GoogleSheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.security.GeneralSecurityException;

@EnableScheduling
@SpringBootApplication
public class SpringBootForBeginnersApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootForBeginnersApplication.class, args);
	}


}

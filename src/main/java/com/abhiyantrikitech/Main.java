package com.abhiyantrikitech;																	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import javax.sql.DataSource;
@EnableAsync
@EnableScheduling
@SpringBootApplication	
public class Main {	
	
	@Value("${serverfilepath}")	
	private String imageFilePath;
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);	
	}
		
}

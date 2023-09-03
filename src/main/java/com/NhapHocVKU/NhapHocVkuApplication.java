package com.NhapHocVKU;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NhapHocVkuApplication {

	public static void main(String[] args) {
		SpringApplication.run(NhapHocVkuApplication.class, args);
		
		System.out.println("lehieu");
	}

}

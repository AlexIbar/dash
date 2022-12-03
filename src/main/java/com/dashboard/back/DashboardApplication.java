package com.dashboard.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DashboardApplication {

	public static void main(String[] args) {
		System.out.print(new BCryptPasswordEncoder().encode("Edwin"));
		SpringApplication.run(DashboardApplication.class, args);
	}

}

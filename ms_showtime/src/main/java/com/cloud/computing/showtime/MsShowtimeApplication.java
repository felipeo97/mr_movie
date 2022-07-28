package com.cloud.computing.showtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsShowtimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsShowtimeApplication.class, args);
	}

}

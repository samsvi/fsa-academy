package com.example.fsatask;

import com.example.fsatask.api.DvdRentalApi;
import com.example.fsatask.application.DvdRentalApiService;
import com.example.fsatask.application.DvdRentalApiServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class FsaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsaTaskApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DvdRentalApiServiceImpl dvdRentalApiService) {
		return (args) -> {
			System.out.println(dvdRentalApiService.getAddressById(1L).address);
		};
	}

}

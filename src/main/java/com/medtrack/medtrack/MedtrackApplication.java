package com.medtrack.medtrack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedtrackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedtrackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Misericordia");

	}
}

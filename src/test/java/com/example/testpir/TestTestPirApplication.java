package com.example.testpir;

import org.springframework.boot.SpringApplication;

public class TestTestPirApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestPirApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

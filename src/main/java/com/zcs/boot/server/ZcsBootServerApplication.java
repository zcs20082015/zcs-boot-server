package com.zcs.boot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ZcsBootServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZcsBootServerApplication.class, args);
	}
}

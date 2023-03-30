package com.tutorials.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScans({
		@ComponentScan("com.tutorials.controllers"),
		@ComponentScan("com.tutorials.configs")
})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringsecuritybasicApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybasicApplication.class, args);
	}
}

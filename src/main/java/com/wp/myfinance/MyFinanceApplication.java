package com.wp.myfinance;

import com.wp.myfinance.Authorization.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MyFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFinanceApplication.class, args);
	}
}

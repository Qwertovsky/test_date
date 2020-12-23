package com.qwertovsky.test.test_date;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.postgresql.ds.PGSimpleDataSource;

@SpringBootApplication
public class TestDateApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", "Europe/Moscow");
		SpringApplication.run(TestDateApplication.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		dataSource.setDatabaseName("test_date");
		return dataSource;
	}
}

package com.qwertovsky.test.test_date;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TestEntity {
	private int id;
	@JsonDeserialize(using = DateDeserializer.class)
	private LocalDate testDate;

	
	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", testDate=" + testDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}
	
}

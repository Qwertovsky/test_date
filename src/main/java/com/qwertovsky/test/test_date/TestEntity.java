package com.qwertovsky.test.test_date;

import java.time.ZonedDateTime;

public class TestEntity {
	private int id;
	private ZonedDateTime testDate;

	
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

	public ZonedDateTime getTestDate() {
		return testDate;
	}

	public void setTestDate(ZonedDateTime testDate) {
		this.testDate = testDate;
	}
}

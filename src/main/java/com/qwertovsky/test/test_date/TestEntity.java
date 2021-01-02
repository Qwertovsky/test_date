package com.qwertovsky.test.test_date;

import java.time.OffsetDateTime;

public class TestEntity {
	private int id;
	private OffsetDateTime testDate;

	
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

	public OffsetDateTime getTestDate() {
		return testDate;
	}

	public void setTestDate(OffsetDateTime testDate) {
		this.testDate = testDate;
	}

}

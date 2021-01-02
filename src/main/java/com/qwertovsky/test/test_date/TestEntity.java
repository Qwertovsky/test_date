package com.qwertovsky.test.test_date;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TestEntity {
	private int id;
	private String zoneId;
	@JsonDeserialize(using = DateDeserializer.class)
	private LocalDateTime testDate;

	
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

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public LocalDateTime getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDateTime testDate) {
		this.testDate = testDate;
	}
	
}

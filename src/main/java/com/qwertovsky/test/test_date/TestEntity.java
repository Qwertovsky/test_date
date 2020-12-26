package com.qwertovsky.test.test_date;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestEntity {
	private int id;
	private String zoneId;
	@JsonSerialize(using = DateSerializer.class)
	private Date testDate;

	
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

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	
	
	
}

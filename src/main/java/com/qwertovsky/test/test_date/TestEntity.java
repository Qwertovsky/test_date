package com.qwertovsky.test.test_date;


import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TestEntity {
	private int id;
	@JsonDeserialize(using = DateDeserializer.class)
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

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	
	
	
}

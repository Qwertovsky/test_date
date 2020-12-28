package com.qwertovsky.test.test_date;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TestEntity {
	private int id;
	@JsonFormat(timezone = TestDateApplication.APP_TIMEZONE, pattern = "yyyy-MM-dd")
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

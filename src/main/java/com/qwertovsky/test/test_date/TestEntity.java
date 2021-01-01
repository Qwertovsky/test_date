package com.qwertovsky.test.test_date;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TestEntity {
	private int id;
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = TestDateApplication.APP_TIMEZONE)
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

package com.qwertovsky.test.test_date;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/test")
public class TestController {

	private static final Logger logger = LogManager.getLogger(TestController.class);

	@Autowired
	private DataSource dataSource;

	@GetMapping("all")
	public List<TestEntity> getEntities() throws Exception {
		var entities = new ArrayList<TestEntity>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"select * from test_table");) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TestEntity entity = new TestEntity();
				entity.setId(rs.getInt("id"));
				entity.setTestDate(rs.getDate("test_date"));
				entities.add(entity);
			}
		}
		logger.info(entities);
		return entities;
	}
	
	@GetMapping
	public TestEntity getEntity(@RequestParam int id) throws Exception {
		TestEntity entity = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"select * from test_table where id=?");) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				entity = new TestEntity();
				entity.setId(id);
				entity.setTestDate(rs.getDate("test_date"));
			}
		}
		
		return entity;
	}

	@PostMapping
	public int saveEntity(@RequestBody TestEntity entity) throws Exception {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"""
						insert into test_table (test_date)
						values (?)
						""",
						PreparedStatement.RETURN_GENERATED_KEYS)
			) {
			String zoneId = entity.getZoneId();
			statement.setDate(1,
					new Date(entity.getTestDate().getTime()),
					Calendar.getInstance(TimeZone.getTimeZone(zoneId)));
			logger.info(statement.unwrap(PreparedStatement.class).toString());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			int id = rs.getInt("id");
			return id;
		}
	}
	
}
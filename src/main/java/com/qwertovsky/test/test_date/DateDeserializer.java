package com.qwertovsky.test.test_date;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class DateDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (p.hasToken(JsonToken.VALUE_STRING)) {
			String text = p.getText().trim();
			try {
				DateTimeFormatter formatter = new DateTimeFormatterBuilder()
						.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
						.appendZoneId()
						.toFormatter()
						;
				LocalDateTime result = ZonedDateTime.parse(text, formatter)
						.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
				return result;
			} catch (Exception e) {
				throw new InvalidFormatException(p, "Wrong date", text, Date.class);
			}
		}
		return (LocalDateTime) ctxt.handleUnexpectedToken(LocalDateTime.class, p);
	}
}

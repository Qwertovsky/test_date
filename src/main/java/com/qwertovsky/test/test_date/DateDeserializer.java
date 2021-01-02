package com.qwertovsky.test.test_date;

import java.io.IOException;
import java.time.LocalDate;
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

public class DateDeserializer extends JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (p.hasToken(JsonToken.VALUE_STRING)) {
			String text = p.getText().trim();
			try {
				DateTimeFormatter formatter = new DateTimeFormatterBuilder()
						.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
						.appendZoneId()
						.toFormatter()
						;
				LocalDate result = ZonedDateTime.parse(text, formatter)
						.withZoneSameInstant(ZoneId.systemDefault()).toLocalDate();
				return result;
			} catch (Exception e) {
				throw new InvalidFormatException(p, "Wrong date", text, Date.class);
			}
		}
		return (LocalDate) ctxt.handleUnexpectedToken(LocalDate.class, p);
	}
}

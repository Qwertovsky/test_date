package com.qwertovsky.test.test_date;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class DateDeserializer extends JsonDeserializer<Date> {

	private static final String format = "yyyy-MM-dd'T'HH:mm:ss";

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (p.hasToken(JsonToken.VALUE_STRING)) {
			String text = p.getText().trim();
			if (text.length() != format.length() - 2) {
				throw new InvalidFormatException(p, "Wrong date", text, Date.class);
			}
			try {
				Date result = new SimpleDateFormat(format).parse(text);
				return result;
			} catch (ParseException e) {
				throw new InvalidFormatException(p, "Wrong date", text, Date.class);
			}
		}
		return (Date) ctxt.handleUnexpectedToken(Date.class, p);
	}
}

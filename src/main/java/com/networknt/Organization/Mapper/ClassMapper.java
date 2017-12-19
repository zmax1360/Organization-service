package com.networknt.Organization.Mapper;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClassMapper<T> {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	public  T mapper(String value,Class<T> valueType ) throws IOException{
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(value, valueType);
	}
	
}

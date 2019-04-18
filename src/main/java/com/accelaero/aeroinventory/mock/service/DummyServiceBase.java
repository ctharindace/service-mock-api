package com.accelaero.aeroinventory.mock.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class DummyServiceBase<T> {

	public List<T> getListFromFile(String filePathName) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> list = new ArrayList<>();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			InputStream jsonStream = new ClassPathResource(filePathName).getInputStream();
			JsonNode jsonNode = mapper.readTree(jsonStream);
			list = mapper.convertValue(jsonNode, this.getListTypeRef());

		} catch (JsonParseException jpe) {
			log.error("Cannot parse the json", jpe);
		} catch (IOException fe) {
			log.error("File not found", fe);
		} catch (Exception fe) {
			log.error("Could not map json", fe);
		}

		return list;
	}

	public abstract TypeReference getListTypeRef();
}

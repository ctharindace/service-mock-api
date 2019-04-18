package com.accelaero.aeroinventory.mock.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.accelaero.aeroinventory.mock.dto.AircraftModelDTO;
import com.fasterxml.jackson.core.type.TypeReference;

@Component
public class DummyAircraftService extends DummyServiceBase<AircraftModelDTO> {
	@Override
	public TypeReference getListTypeRef() {
		return new TypeReference<List<AircraftModelDTO>>() {
		};
	}

}

package com.accelaero.aeroinventory.mock.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.accelaero.aeroinventory.mock.dto.CabinClassDTO;
import com.fasterxml.jackson.core.type.TypeReference;

@Component
public class DummyCabinClassService extends DummyServiceBase<CabinClassDTO> {

	@Override
	public TypeReference getListTypeRef() {
		return new TypeReference<List<CabinClassDTO>>() {
		};
	}
}

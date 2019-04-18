package com.accelaero.aeroinventory.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accelaero.aeroinventory.mock.RemoteMasterDataService;
import com.accelaero.aeroinventory.mock.dto.AircraftModelDTO;
import com.accelaero.aeroinventory.mock.dto.CabinClassDTO;

@Controller
@RequestMapping("mock/aeromaster")
public class AeroMasterMockController {

	@Autowired
	private RemoteMasterDataService remoteMasterDataService;

	@ResponseBody
	@RequestMapping(value = "/cabinClasses", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<CabinClassDTO> getCabinClasses() {
		return remoteMasterDataService.getCabinClasses();
	}

	@ResponseBody
	@RequestMapping(value = "/aircraftModels", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<AircraftModelDTO> getAircraftModels() {
		return remoteMasterDataService.getAircraftModels();

	}

}

package com.accelaero.aeroinventory.mock;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.accelaero.aeroinventory.mock.dto.AircraftModelDTO;
import com.accelaero.aeroinventory.mock.dto.CabinClassDTO;
import com.accelaero.aeroinventory.mock.service.DummyAircraftService;
import com.accelaero.aeroinventory.mock.service.DummyCabinClassService;
import com.accelaero.aeroinventory.mock.util.Constants;

@Component
public class RemoteMasterDataService {

	private static final String CABIN_CLASS_JSON = File.separator + "dummy-service" + File.separator
			+ "cabin-class.json";

	private static final String AIRCRAFT_MODEL_JSON = File.separator + "dummy-service" + File.separator
			+ "aircraft-model.json";

	@Autowired
	private DummyCabinClassService cabinClassService;

	@Autowired
	private DummyAircraftService aircraftService;

	private ResourceLoader resourceLoader;

	public List<CabinClassDTO> getCabinClasses() {
		return cabinClassService.getListFromFile(CABIN_CLASS_JSON);
	}

	public List<AircraftModelDTO> getAircraftModels() {
		return aircraftService.getListFromFile(AIRCRAFT_MODEL_JSON);
	}

	public List<AircraftModelDTO> getActiveAircraftModels() {
		List<AircraftModelDTO> aircraftModels = this.getAircraftModels();
		List<AircraftModelDTO> activeAircraftModels = aircraftModels.stream()
				.filter(aircraftModel -> Constants.Status.ACTIVE.equals(aircraftModel.getStatus()))
				.collect(Collectors.toList());
		return activeAircraftModels;
	}

	public List<CabinClassDTO> getActiveCabinClasses() {
		List<CabinClassDTO> cabinClasses = this.getCabinClasses();
		List<CabinClassDTO> activeCabinClasses = cabinClasses.stream()
				.filter(cabinClass -> Constants.Status.ACTIVE.equals(cabinClass.getStatus()))
				.collect(Collectors.toList());
		return activeCabinClasses;
	}

}

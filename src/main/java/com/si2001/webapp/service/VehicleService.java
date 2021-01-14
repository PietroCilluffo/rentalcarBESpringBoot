package com.si2001.webapp.service;

import java.util.List;

import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.entities.Vehicle;

public interface VehicleService {
	long insVehicle(VehicleDto vehicle);
	void elVehicleId(long id);
	void aggVehicle(VehicleDto vehicle);
	VehicleDto cercaVehicleId(long id);
	List<VehicleDto>  trovaTutti();
	void elVehicle(VehicleDto vehicle);
	List<VehicleDto> trovaPerModello(String modello);
	List<VehicleDto> trovaPerCasa(String casa);
	List<VehicleDto> trovaPerAnno(String anno);
	List<VehicleDto> trovaPerTarga(String anno);
}

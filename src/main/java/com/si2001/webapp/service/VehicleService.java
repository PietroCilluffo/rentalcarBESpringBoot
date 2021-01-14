package com.si2001.webapp.service;

import java.util.List;

import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.entities.Vehicle;

public interface VehicleService {
	long insVehicle(Vehicle vehicle);
	void elVehicleId(long id);
	void aggVehicle(Vehicle vehicle);
	Vehicle cercaVehicleId(long id);
	List<VehicleDto>  trovaTutti();
	void elVehicle(Vehicle vehicle);
	List<Vehicle> trovaPerModello(String modello);
	List<Vehicle> trovaPerCasa(String casa);
	List<Vehicle> trovaPerAnno(String anno);
}

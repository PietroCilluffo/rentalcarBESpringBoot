package com.si2001.webapp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.entities.Vehicle;
import com.si2001.webapp.repository.VehicleRepository;
import com.si2001.webapp.service.VehicleService;
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
  @Autowired
  VehicleRepository vehicleRepo;
  @Autowired
  private ModelMapper modelMapper;
@Override
public long insVehicle(Vehicle vehicle) {
	// TODO Auto-generated method stub
	vehicleRepo.save(vehicle);
	return 0;
}

@Override
public void elVehicleId(long id) {
	// TODO Auto-generated method stub
	Vehicle vehicle = vehicleRepo.findById(id);
	vehicleRepo.delete(vehicle);
}

@Override
public void aggVehicle(Vehicle vehicle) {
	// TODO Auto-generated method stub
	vehicleRepo.save(vehicle);
}

@Override
public Vehicle cercaVehicleId(long id) {
	// TODO Auto-generated method stub
	return vehicleRepo.findById(id);
}

@Override
public List<VehicleDto> trovaTutti() {
	// TODO Auto-generated method stub
	List<Vehicle> vehicles = vehicleRepo.findAll();
	
	List<VehicleDto> dtos = null;
	for(int i = 0; i<vehicles.size(); i++) {
		Vehicle v = vehicles.get(i);
		dtos.add(modelMapper.map(v, VehicleDto.class)) ;
	}
	return dtos;
	
}

@Override
public void elVehicle(Vehicle vehicle) {
	// TODO Auto-generated method stub
	vehicleRepo.delete(vehicle);
}

@Override
public List<Vehicle> trovaPerModello(String modello) {
	// TODO Auto-generated method stub
	return vehicleRepo.findByModello(modello);
}

@Override
public List<Vehicle> trovaPerCasa(String casa) {
	// TODO Auto-generated method stub
	return vehicleRepo.findByCasa(casa);
}

@Override
public List<Vehicle> trovaPerAnno(String anno) {
	// TODO Auto-generated method stub
	return vehicleRepo.findByAnno(anno);
}
  
}

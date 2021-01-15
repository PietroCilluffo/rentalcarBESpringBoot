package com.si2001.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.si2001.webapp.dto.UserDto;
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
public long insVehicle(VehicleDto vehicle) {
	// TODO Auto-generated method stub
	Vehicle v = modelMapper.map(vehicle,Vehicle.class);
	vehicleRepo.save(v);
	return 0;
}

@Override
public void elVehicleId(long id) {
	// TODO Auto-generated method stub
	Vehicle vehicle = vehicleRepo.findById(id);
	vehicleRepo.delete(vehicle);
}

@Override
public void aggVehicle(VehicleDto vehicle) {
	// TODO Auto-generated method stub
	Vehicle v = modelMapper.map(vehicle,Vehicle.class);
	vehicleRepo.save(v);
}

@Override
public VehicleDto cercaVehicleId(long id) {
	// TODO Auto-generated method stub
	Vehicle vehicle =  vehicleRepo.findById(id);
	return modelMapper.map(vehicle,VehicleDto.class);
}

@Override
public List<VehicleDto> trovaTutti() {
	// TODO Auto-generated method stub
	List<Vehicle> vehicles = vehicleRepo.findAll();
	
	List<VehicleDto> dtos = new ArrayList<VehicleDto>();
	for(int i = 0; i<vehicles.size(); i++) {
		Vehicle v = vehicles.get(i);
		dtos.add(modelMapper.map(v, VehicleDto.class)) ;
	}
	return dtos;
	
}

@Override
public void elVehicle(VehicleDto vehicle) {
	// TODO Auto-generated method stub
	Vehicle v = modelMapper.map(vehicle,Vehicle.class);
	vehicleRepo.delete(v);
}

@Override
public List<VehicleDto> trovaPerModello(String modello) {
	// TODO Auto-generated method stub
	List<Vehicle> vehicles = vehicleRepo.findByModello(modello);
	List<VehicleDto> dtos = new ArrayList<VehicleDto>();
	for(int i = 0; i<vehicles.size(); i++) {
		Vehicle v = vehicles.get(i);
		dtos.add(modelMapper.map(v, VehicleDto.class)) ;
	}
	return dtos;
}

@Override
public List<VehicleDto> trovaPerCasa(String casa) {
	// TODO Auto-generated method stub
	List<Vehicle> vehicles = vehicleRepo.findByCasa(casa);
	List<VehicleDto> dtos = new ArrayList<VehicleDto>();
	for(int i = 0; i<vehicles.size(); i++) {
		Vehicle v = vehicles.get(i);
		dtos.add(modelMapper.map(v, VehicleDto.class)) ;
	}
	return dtos;
}

@Override
public List<VehicleDto> trovaPerAnno(String anno) {
	// TODO Auto-generated method stub
	List<Vehicle> vehicles = vehicleRepo.findByAnno(anno);
	List<VehicleDto> dtos = new ArrayList<VehicleDto>();
	for(int i = 0; i<vehicles.size(); i++) {
		Vehicle v = vehicles.get(i);
		dtos.add(modelMapper.map(v, VehicleDto.class)) ;
	}
	return dtos;
}
@Override
public List<VehicleDto> trovaPerTarga(String targa) {
	// TODO Auto-generated method stub
	List<Vehicle> vehicles = vehicleRepo.findByTarga(targa);
	List<VehicleDto> dtos = new ArrayList<VehicleDto>();
	for(int i = 0; i<vehicles.size(); i++) {
		Vehicle v = vehicles.get(i);
		dtos.add(modelMapper.map(v, VehicleDto.class)) ;
	}
	return dtos;
}
  
}

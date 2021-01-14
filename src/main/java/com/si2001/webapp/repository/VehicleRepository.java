package com.si2001.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si2001.webapp.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
	List<Vehicle> findAll();
	
	Vehicle findById(long id);
	
	Vehicle save(Vehicle vehicle);
	
	void delete(Vehicle vehicle);
	
	List<Vehicle> findByTarga(String targa);
	
	List<Vehicle> findByCasa(String casa);
	
	List<Vehicle> findByModello(String modello);
	
	List<Vehicle> findByAnno(String anno);
	
}

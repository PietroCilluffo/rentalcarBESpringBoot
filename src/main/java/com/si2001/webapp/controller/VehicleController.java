package com.si2001.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping(value = "/find", produces = "application/json")
	public ResponseEntity<List<VehicleDto>> findAll(){
		List<VehicleDto> vehicles = vehicleService.trovaTutti();
		return new ResponseEntity<List<VehicleDto>>(vehicles, HttpStatus.OK);
	}
	
}

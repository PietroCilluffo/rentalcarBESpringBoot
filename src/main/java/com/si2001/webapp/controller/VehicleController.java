package com.si2001.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.service.VehicleService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleDto.class);
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value = "/find", produces = "application/json")
	public ResponseEntity<List<VehicleDto>> findAll(){
		logger.info("****** Find " + " *******");
		List<VehicleDto> vehicles = vehicleService.trovaTutti();
		return new ResponseEntity<List<VehicleDto>>(vehicles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/casa/{param}", produces = "application/json")
	public ResponseEntity<List<VehicleDto>> findByCasa(@PathVariable("param")String param){
		logger.info("****** Find " + " *******");
		List<VehicleDto> vehicles = vehicleService.trovaPerCasa(param);
		return new ResponseEntity<List<VehicleDto>>(vehicles, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{param}", produces = "application/json")
	public ResponseEntity<VehicleDto> findById(@PathVariable("param")long param){
		logger.info("****** Find vehicle  " + param + " *******");
		VehicleDto vehicles = vehicleService.cercaVehicleId(param);
		return new ResponseEntity<VehicleDto>(vehicles, HttpStatus.OK);
	}
	@GetMapping(value = "/find/modello/{param}", produces = "application/json")
	public ResponseEntity<List<VehicleDto>> findByModello(@PathVariable("param")String param){
		logger.info("****** Find " + " *******");
		List<VehicleDto> vehicles = vehicleService.trovaPerModello(param);
		return new ResponseEntity<List<VehicleDto>>(vehicles, HttpStatus.OK);
	}
	@GetMapping(value = "/find/anno/{param}", produces = "application/json")
	public ResponseEntity<List<VehicleDto>> findByAnno(@PathVariable("param")String param){
		logger.info("****** Find " + " *******");
		List<VehicleDto> vehicles = vehicleService.trovaPerAnno(param);
		return new ResponseEntity<List<VehicleDto>>(vehicles, HttpStatus.OK);
	}
	@GetMapping(value = "/find/targa/{param}", produces = "application/json")
	public ResponseEntity<List<VehicleDto>> findByTarga(@PathVariable("param")String param){
		logger.info("****** Find targa " +param + " *******");
		List<VehicleDto> vehicles = vehicleService.trovaPerTarga(param);
		return new ResponseEntity<List<VehicleDto>>(vehicles, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addVehicle(@RequestBody VehicleDto dto){
		logger.info("****** Find " + " *******");
		vehicleService.insVehicle(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", String.format("Inserimento Veicolo Eseguito Con Successo"));
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteVehicleById(@PathVariable("id") long id){
		vehicleService.elVehicleId(id);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Veicolo " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteVehicle(@RequestBody VehicleDto dto){
		vehicleService.elVehicle(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Veicolo " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(value="/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updateVehicle(@RequestBody VehicleDto dto){
		vehicleService.aggVehicle(dto);
		logger.info("****** aggiornamento " + " *******");
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", String.format("Aggiornamento Veicolo Eseguito Con Successo"));
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);
	}
}

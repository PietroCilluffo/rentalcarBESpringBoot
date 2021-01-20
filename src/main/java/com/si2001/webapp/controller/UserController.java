package com.si2001.webapp.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.si2001.webapp.dto.UserDto;
import com.si2001.webapp.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserDto.class);
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/find", produces = "application/json")
	public ResponseEntity<List<UserDto>> findAll(){
		logger.info("****** Find " + " *******");
		List<UserDto> users = userService.trovaTutti();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{param}", produces = "application/json")
	public ResponseEntity<UserDto> findbyId(@PathVariable("param")long param){
		logger.info("****** Find id " + param +" *******");
		UserDto user = userService.cercaUserId(param);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	@GetMapping(value = "/find/nome/{param}", produces = "application/json")
	public ResponseEntity<List<UserDto>> findByNome(@PathVariable("param")String param){
		logger.info("****** Find " + " *******");
		List<UserDto> users = userService.trovaPerNome(param);
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/cognome/{param}", produces = "application/json")
	public ResponseEntity<List<UserDto>> findByCognome(@PathVariable("param")String param){
		logger.info("****** Find " + " *******");
		List<UserDto> users = userService.trovaPerCognome(param);
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	@GetMapping(value = "/find/anno/{param}", produces = "application/json")
	public ResponseEntity<List<UserDto>> findByEmail(@PathVariable("param")String param){
		logger.info("****** Find " + " *******");
		List<UserDto> users = userService.trovaPerEmail(param);
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}

	
	@PostMapping(value = "/add", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody UserDto dto){
		logger.info("****** inserimento " + dto + " *******");
		System.out.println(dto);
		userService.insUser(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", String.format("Inserimento utente Eseguito Con Successo"));
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteVehicleById(@PathVariable("id") long id){
		logger.info("****** eliminazione " + id + " *******");
		System.out.println(id);
		userService.elUserId(id);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Articolo " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteVehicle(@RequestBody UserDto dto){
		logger.info("****** eliminazione utente " + dto + " *******");
		userService.elUser(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Utente " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(value="/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updateVehicle(@RequestBody UserDto dto){
		userService.aggUser(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Agg Articolo " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);
	}
	
}

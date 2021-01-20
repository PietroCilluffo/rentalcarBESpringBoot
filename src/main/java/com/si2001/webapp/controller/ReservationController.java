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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.si2001.webapp.dto.ReservationDto;
import com.si2001.webapp.entities.Reservation;
import com.si2001.webapp.service.ReservationService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	private static final Logger logger = LoggerFactory.getLogger(long.class);
	@Autowired
	private ReservationService reservationService;
	

	@GetMapping(value = "/find", produces = "application/json")
	public ResponseEntity<List<ReservationDto>> findAll(){
		logger.info("****** Find " + " *******");
		List<ReservationDto> reservations = reservationService.trovaTutti();
		return new ResponseEntity<List<ReservationDto>>(reservations, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/idUser/{param}", produces = "application/json")
	public ResponseEntity<List<ReservationDto>> findByIdUser(@PathVariable("param")long param){
		logger.info("****** Find id user r " + param+ " *******");
		List<ReservationDto> reservations = reservationService.trovaPrenotazioniPerUser(param);
		return new ResponseEntity<List<ReservationDto>>(reservations, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{param}", produces = "application/json")
	public ResponseEntity<ReservationDto> findById(@PathVariable("param")long param){
		
		ReservationDto reservation = reservationService.cercaReservationId(param);
		logger.info("****** Find id res " +reservation.dataFine+ " *******");
		return new ResponseEntity<ReservationDto>(reservation, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteVehicleById(@PathVariable("id") long id){
		reservationService.elReservationId(id);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Prenotazione " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> deleteVehicle(@RequestBody ReservationDto dto){
		reservationService.elReservation(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Prenotazione " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(value="/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> addReservawtion(@RequestBody ReservationDto dto){
	//	System.out.println(dto.idUser);
		logger.info("****** add reservation " + dto.approvazione + " *******");
		reservationService.insReservation(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Eliminazione Prenotazione " +  " Eseguita Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(value="/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updateReservation(@RequestBody ReservationDto dto){
		reservationService.aggReservation(dto);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Aggiornamento veicolo " +  " Eseguito Con Successo");
		
		return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);
	}
}

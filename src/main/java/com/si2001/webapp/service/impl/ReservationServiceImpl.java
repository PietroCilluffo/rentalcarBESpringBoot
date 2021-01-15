package com.si2001.webapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.si2001.webapp.dto.ReservationDto;
import com.si2001.webapp.dto.UserDto;
import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.entities.Reservation;
import com.si2001.webapp.repository.ReservationRepository;
import com.si2001.webapp.service.ReservationService;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	private static final Logger logger = LoggerFactory.getLogger(long.class);
	@Autowired
  ReservationRepository reservationRepo;
  @Autowired
  private ModelMapper modelMapper;
@Override
public long insReservation(Reservation reservation) {
	// TODO Auto-generated method stub
	//Reservation r = modelMapper.map(reservation,Reservation.class);
	//logger.info("****** Find " +r+  " *******");
	reservationRepo.save(reservation);
	return 0;
}

@Override
public void elReservationId(long id) {
	// TODO Auto-generated method stub
	Reservation reservation = reservationRepo.findById(id);
	reservationRepo.delete(reservation);
}

@Override
public void aggReservation(ReservationDto reservation) {
	// TODO Auto-generated method stub
	Reservation r = modelMapper.map(reservation,Reservation.class);
	reservationRepo.save(r);
	
}

@Override
public ReservationDto cercaReservationId(long id) {
	// TODO Auto-generated method stub
	Reservation r = reservationRepo.findById(id);
	ReservationDto dto = modelMapper.map(r,ReservationDto.class);
	return dto;
}

@Override
public List<ReservationDto> trovaTutti() {
	// TODO Auto-generated method stub
	
	List<Reservation> reservations =  reservationRepo.findAll();
	List<ReservationDto> dtos = new ArrayList<ReservationDto>();
	for(int i = 0; i<reservations.size(); i++) {
		Reservation r = reservations.get(i);
		//logger.info("****** Find " +r.getId()+  " *******");
		dtos.add(modelMapper.map(r, ReservationDto.class)) ;
	}
	return dtos;
}

@Override
public ReservationDto trovaPrenotazioniPerUser(long idUser) {
	// TODO Auto-generated method stub
	Reservation reservation =  reservationRepo.findById(idUser);
	
	ReservationDto dto = modelMapper.map(reservation, ReservationDto.class);
	
	return dto;
}

@Override
public void elReservation(ReservationDto reservation) {
	// TODO Auto-generated method stub
	Reservation r = modelMapper.map(reservation,Reservation.class);
	reservationRepo.delete(r);
}

@Override
public void approvaPrenotazione(long id) {
	// TODO Auto-generated method stub
	
}
  
}

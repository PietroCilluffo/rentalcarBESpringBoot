package com.si2001.webapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.si2001.webapp.entities.Reservation;
import com.si2001.webapp.repository.ReservationRepository;
import com.si2001.webapp.service.ReservationService;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
  @Autowired
  ReservationRepository reservationRepo;

@Override
public long insReservation(Reservation reservation) {
	// TODO Auto-generated method stub
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
public void aggReservation(Reservation reservation) {
	// TODO Auto-generated method stub
	reservationRepo.save(reservation);
	
}

@Override
public Reservation cercaReservationId(long id) {
	// TODO Auto-generated method stub
	return reservationRepo.findById(id);
}

@Override
public List<Reservation> trovaTutti() {
	// TODO Auto-generated method stub
	return reservationRepo.findAll();
}

@Override
public List<Reservation> trovaPrenotazioniPerUser(long idUser) {
	// TODO Auto-generated method stub
	return reservationRepo.findByIdUser(idUser);
}

@Override
public void elReservation(Reservation reservation) {
	// TODO Auto-generated method stub
	reservationRepo.delete(reservation);
}

@Override
public void approvaPrenotazione(long id) {
	// TODO Auto-generated method stub
	
}
  
}

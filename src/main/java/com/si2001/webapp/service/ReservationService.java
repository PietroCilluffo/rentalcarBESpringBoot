package com.si2001.webapp.service;

import java.util.List;

import com.si2001.webapp.dto.ReservationDto;
import com.si2001.webapp.entities.Reservation;


public interface ReservationService {
	long insReservation(Reservation reservation);
	void elReservationId(long id);
	void aggReservation(ReservationDto reservation);
	ReservationDto cercaReservationId(long id);
	List<ReservationDto> trovaTutti();
	ReservationDto trovaPrenotazioniPerUser(long idUser);
	void elReservation(ReservationDto reservation);
	void approvaPrenotazione(long id);
}

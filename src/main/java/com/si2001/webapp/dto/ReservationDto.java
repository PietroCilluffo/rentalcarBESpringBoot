package com.si2001.webapp.dto;
import java.time.LocalDate;
public class ReservationDto {
	long id;
	LocalDate dataInizio;
	LocalDate dataFine;
	boolean approvazione;
	long idUser;
	long idVehicle;
}

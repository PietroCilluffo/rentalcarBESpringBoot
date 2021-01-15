package com.si2001.webapp.dto;
import java.time.LocalDate;
import java.util.Date;

import com.si2001.webapp.entities.User;
import com.si2001.webapp.entities.Vehicle;

import lombok.Data;
@Data
public class ReservationDto {
	public long id;
	public String  dataInizio;
	public	String  dataFine;
	public boolean approvazione;
	public User user = new User();
	public Vehicle vehicle = new Vehicle();
}

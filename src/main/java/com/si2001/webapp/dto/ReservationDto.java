package com.si2001.webapp.dto;
import java.time.LocalDate;
import java.util.Date;

import com.si2001.webapp.entities.User;
import com.si2001.webapp.entities.Vehicle;

import lombok.Data;
@Data
public class ReservationDto {
	public long id;
	public Date  dataInizio;
	public	Date  dataFine;
	public boolean approvazione;
	public UserDto user = new UserDto();
	public VehicleDto vehicle = new VehicleDto();
}

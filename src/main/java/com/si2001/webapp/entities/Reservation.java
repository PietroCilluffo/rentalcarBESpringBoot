package com.si2001.webapp.entities;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5371340850814511699L;



	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

	 @Column(name = "id")
	 private long id;
	 

	

	@Temporal(TemporalType.DATE)
	 @Column(name = "data_inizio")
	// @DateTimeFormat(pattern="dd-MM-yyyy")
	 private Date dataInizio;
	 
	 @Temporal(TemporalType.DATE)
	 @Column(name = "data_fine")
	// @DateTimeFormat(pattern="dd-MM-yyyy")
	 
	 private Date dataFine;
	
	
	 @Column(name = "approvazione")
	 private boolean approvazione;
	 
	 @ManyToOne
	 @EqualsAndHashCode.Exclude   //nelle notazioni manytoone altrimenti il lombok va in crisi
	 @JoinColumn(name = "id_user",referencedColumnName = "id")
	 @JsonBackReference //parte finale delle serializzazione
	// @JsonIgnoreProperties(value = {"reservation", "hibernateLazyInitializer"})
	 public User user;
	 
	 
	 @ManyToOne
	 @EqualsAndHashCode.Exclude   //nelle notazioni manytoone altrimenti il lombok va in crisi
	 @JoinColumn(name = "id_vehicle",referencedColumnName = "id")
	 @JsonBackReference //parte finale delle serializzazione
	// @JsonIgnoreProperties(value = {"reservation", "hibernateLazyInitializer"})
	 public Vehicle vehicle;

	 public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public Date getDataInizio() {
			return dataInizio;
		}


		public void setDataInizio(Date dataInizio) {
			this.dataInizio = dataInizio;
		}


		public Date getDataFine() {
			return dataFine;
		}


		public void setDataFine(Date dataFine) {
			this.dataFine = dataFine;
		}


		public boolean isApprovazione() {
			return approvazione;
		}


		public void setApprovazione(boolean approvazione) {
			this.approvazione = approvazione;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Vehicle getVehicle() {
			return vehicle;
		}


		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}

	
}
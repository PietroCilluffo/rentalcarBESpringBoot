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

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
@Table(name = "reservation")

public class Reservation implements Serializable {
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

	 @Column(name = "id")
	 private long id;
	 

	
	 @Column(name = "dataInizio", columnDefinition="TIMESTAMP")
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 private LocalDate dataInizio;
	 
	 
	 @Column(name = "dataFine", columnDefinition="TIMESTAMP")
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 private LocalDate dataFine;
	
	
	 @Column(name = "approvazione")
	 private boolean approvazione;
	 
	 @ManyToOne(cascade = { CascadeType.REMOVE})
	 @EqualsAndHashCode.Exclude   //nelle notazioni manytoone altrimenti il lombok va in crisi
	 @JoinColumn(name = "idUser",referencedColumnName = "id")
	 @JsonBackReference //parte finale delle serializzazione
	
	 private User user;
	 
	 
	 @ManyToOne
	 @EqualsAndHashCode.Exclude   //nelle notazioni manytoone altrimenti il lombok va in crisi
	 @JoinColumn(name = "idVehicle",referencedColumnName = "id")
	 @JsonBackReference //parte finale delle serializzazione
	 private Vehicle vehicle;
}
package com.si2001.webapp.entities;


import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import javax.persistence.OneToMany;

@Entity
@Data
@Table(name = "vehicle")


public class Vehicle  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	 @Column(name = "id")
	 private long id;
	
	 @Column(name = "targa")
	 private String targa;
	 
	 @Column(name = "modello")
	 private String modello;
	 
	 @Column(name = "casa")
	 private String casa;

	 @Column(name = "anno")
	 private String anno;

	@OneToMany (mappedBy = "vehicle",cascade = { CascadeType.ALL})
	@JsonManagedReference 
	 private List<Reservation> reservations;
	 public List<Reservation> getReservation() {
			return reservations;
		}
	public Vehicle() {
		
	}
	
	public Vehicle(String targa, String modello,String casa,String anno) {
		this.targa = targa;
		this.modello = modello;
		this.casa = casa;
		this.anno = anno;
	}
}
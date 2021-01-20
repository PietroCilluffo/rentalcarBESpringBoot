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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import javax.persistence.OneToMany;

@Entity
//@Data
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

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "vehicle",cascade = { CascadeType.ALL})
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
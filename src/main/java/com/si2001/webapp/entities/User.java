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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import javax.persistence.OneToMany;



@Entity
@Data
@Table(name = "user")

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 
 @Column(name = "id")
 private long id;
 
 @Column(name = "nome")
 private String nome;
 
 @Column(name = "cognome")
 private String cognome;
 
 @Column(name = "email")
 private String email;

 @Column(name = "password")
 private String password;

 @Column(name = "tipo")
 private String tipo;

@OneToMany (fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.REMOVE)
//@JsonManagedReference   //poichè i dati vengono mappati e serializzati dal db in formato json
 private List<Reservation> reservations;
	public List<Reservation> getReservation() {
		return reservations;
	}
 //buona pratica scrivere un costruttore vuoto
 public User() {
	 
 }
 
 public User(String nome, String cognome, String email, String password) {
	 this.nome = nome;
	 this.cognome = cognome;
	 this.email = email;
	 this.password = password;

	 
 }
}
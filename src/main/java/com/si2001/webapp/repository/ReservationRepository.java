package com.si2001.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si2001.webapp.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
   List<Reservation> findAll();
   
   Reservation save(Reservation reservation);
   
   void delete (Reservation reservation);
   
   List<Reservation> findByIdUser(long idUser);
   
   Reservation findById(long id);
   
}

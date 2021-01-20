package com.si2001.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si2001.webapp.entities.Reservation;
import com.si2001.webapp.entities.User;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
   List<Reservation> findAll();
   
   Reservation save(Reservation reservation);
   
   void delete (Reservation reservation);
   
   //Reservation findByIdUser(Integer idUser);
 
   List<Reservation> findByUser(User user);
   Reservation findById(long id);
   
}

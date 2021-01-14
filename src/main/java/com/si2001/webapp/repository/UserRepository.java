package com.si2001.webapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si2001.webapp.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
   List<User> findAll();
   
   User findById(long id);
   
   User save(User user);
   
   void delete(User user);
   
   List<User> findByNome(String nome);
   
   List<User> findByCognome(String cognome);
   
   List<User> findByEmail(String email);
}

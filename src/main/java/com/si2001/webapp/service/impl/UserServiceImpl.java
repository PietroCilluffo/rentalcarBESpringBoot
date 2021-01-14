package com.si2001.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.si2001.webapp.entities.User;
import com.si2001.webapp.repository.UserRepository;
import com.si2001.webapp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
  
	@Autowired 
	UserRepository userRepo;

	@Override
	public long insUser(User user) {
		// TODO Auto-generated method stub
		
		userRepo.save(user);
		return 0;
	}

	@Override
	public void elUserId(long id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id);
		userRepo.delete(user);
	}

	@Override
	public void aggUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public User cercaUserId(long id) {
		// TODO Auto-generated method stub
		
		return userRepo.findById(id);
	}

	@Override
	public List<User> trovaTutti() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public List<User> trovaPerNome(String nome) {
		// TODO Auto-generated method stub
		return userRepo.findByNome(nome);
	}

	@Override
	public List<User> trovaPerCognome(String cognome) {
		// TODO Auto-generated method stub
		return userRepo.findByCognome(cognome);
	}

	@Override
	public List<User> trovaPerEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public void elUser(User user) {
		// TODO Auto-generated method stub
		userRepo.delete(user);
	}
	
	
}

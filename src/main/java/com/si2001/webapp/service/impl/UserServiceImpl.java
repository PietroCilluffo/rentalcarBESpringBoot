package com.si2001.webapp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.si2001.webapp.dto.UserDto;
import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.entities.User;
import com.si2001.webapp.entities.Vehicle;
import com.si2001.webapp.repository.UserRepository;
import com.si2001.webapp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
  
	@Autowired 
	UserRepository userRepo;
	@Autowired
    private ModelMapper modelMapper;
	@Override
	public long insUser(UserDto user) {
		// TODO Auto-generated method stub
		User u = modelMapper.map(user,User.class);
		userRepo.save(u);
		return 0;
	}

	@Override
	public void elUserId(long id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id);
		userRepo.delete(user);
	}

	@Override
	public void aggUser(UserDto user) {
		// TODO Auto-generated method stub
		User u = modelMapper.map(user,User.class);
		userRepo.save(u);
	}

	@Override
	public UserDto cercaUserId(long id) {
		// TODO Auto-generated method stub
		
		User u =  userRepo.findById(id);
		UserDto dto = modelMapper.map(u,UserDto.class);
		return dto;
	}

	@Override
	public List<UserDto> trovaTutti() {
		// TODO Auto-generated method stub
		
		List<User> users = userRepo.findAll();
		
		List<UserDto> dtos = null;
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			dtos.add(modelMapper.map(u, UserDto.class)) ;
		}
		return dtos;
	}

	@Override
	public List<UserDto> trovaPerNome(String nome) {
		// TODO Auto-generated method stub
		
	List<User> users = userRepo.findByNome(nome);
		
		List<UserDto> dtos = null;
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			dtos.add(modelMapper.map(u, UserDto.class)) ;
		}
		return dtos;
	}

	@Override
	public List<UserDto> trovaPerCognome(String cognome) {
		// TODO Auto-generated method stub
		List<User> users =  userRepo.findByCognome(cognome);
		List<UserDto> dtos = null;
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			dtos.add(modelMapper.map(u, UserDto.class)) ;
		}
		return dtos;
	}

	@Override
	public List<UserDto> trovaPerEmail(String email) {
		// TODO Auto-generated method stub
		List<User> users =  userRepo.findByEmail(email);
		List<UserDto> dtos = null;
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			dtos.add(modelMapper.map(u, UserDto.class)) ;
		}
		return dtos;
		
	}

	@Override
	public void elUser(UserDto user) {
		// TODO Auto-generated method stub
		User u = modelMapper.map(user,User.class);
		userRepo.delete(u);
	}
	
	
}

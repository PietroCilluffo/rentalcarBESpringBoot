package com.si2001.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.si2001.webapp.dto.VehicleDto;
import com.si2001.webapp.entities.User;
import com.si2001.webapp.repository.UserRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(String.class);
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<User> users = userRepo.findByEmail(username);
		User user = users.get(0);
		logger.info("****** Find user in service " +user.getEmail() + user.getPassword()+ " *******");
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
}
}
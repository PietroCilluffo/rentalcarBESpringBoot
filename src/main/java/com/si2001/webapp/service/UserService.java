package com.si2001.webapp.service;

import java.util.List;

import com.si2001.webapp.dto.UserDto;


public interface UserService {
 
	long insUser(UserDto user);
	void elUserId(long id);
	void aggUser(UserDto user);
	UserDto cercaUserId(long id);
	List<UserDto> trovaTutti();
	List<UserDto> trovaPerNome(String nome);
	List<UserDto> trovaPerCognome(String cognome);
	List<UserDto> trovaPerEmail(String email);
	void elUser(UserDto user);
}

package com.si2001.webapp.dto;

import lombok.Data;

@Data
public class UserDto {
   long id;
   String nome;
   String cognome;
   String email;
   String password;
   String tipo;
}

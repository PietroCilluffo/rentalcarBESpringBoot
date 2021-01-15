package com.si2001.webapp.dto;

import lombok.Data;

@Data
public class UserDto {
   private long id;
   private String nome;
   private String cognome;
   private String email;
   private String password;
   private String tipo;
}

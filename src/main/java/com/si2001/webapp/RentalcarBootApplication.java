package com.si2001.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.si2001.webapp.controller.ReservationController;
import com.si2001.webapp.controller.UserController;
import com.si2001.webapp.controller.VehicleController;

@SpringBootApplication
public class RentalcarBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalcarBootApplication.class, args);
	}

}

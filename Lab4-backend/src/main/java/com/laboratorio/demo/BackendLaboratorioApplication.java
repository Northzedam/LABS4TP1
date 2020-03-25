package com.laboratorio.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

@SpringBootApplication
public class BackendLaboratorioApplication {

	private static File home;
	
	public static File getHome() {
		ApplicationHome home = new ApplicationHome(BackendLaboratorioApplication.class);
		return home.getSource();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(BackendLaboratorioApplication.class, args);
	}

}

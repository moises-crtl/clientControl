package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan("com.example.demo")
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		template.execute("CREATE DATABASE Client;");
//		template.execute("CREATE TABLE Clients(idClient INTEGER(10) PRIMARY KEY AUTO_INCREMENT, codigo INTEGER(10), "
//				+ "nombre VARCHAR(255), sexo VARCHAR(10), telefono VARCHAR(12), cedula VARCHAR(12), numIdentificador VARCHAR(12), "
//				+ "ciudad VARCHAR(20), provincia VARCHAR(15), barrio VARCHAR(20), direccion1 VARCHAR(255), direccion2 VARCHAR(255), estatus VARCHAR(5))");
	}

}
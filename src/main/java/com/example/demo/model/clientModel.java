package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class clientModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private int codigo;
	private String nombre;
	private Date fecha;
	private String sexo;
	private String telefono;
	private String cedula;
	private String numIdentificador;
	private String ciudad;
	private String provincia;
	private String barrio;
	private String direccion1;
	private String direccion2;
	private String estatus;
}

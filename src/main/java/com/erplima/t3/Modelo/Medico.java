package com.erplima.t3.Modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	private String nombre;
	private String apellido;
	private String email;
	private String dni;
	private String estadoCivil;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE)
	private Date fechaNacimiento;
	
	
	public Medico(int idMedico, String nombre, String apellido, String email, String dni, String estadoCivil, Date fechaNacimiento) 
	{
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Medico() { }

	public int getIdMedico() { return idMedico; }
	public void setIdMedico(int idMedico) { this.idMedico = idMedico; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getDni() { return dni; }
	public void setDni(String dni) { this.dni = dni; }

	public String getEstadoCivil() { return estadoCivil; }
	public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

	public Date getFechaNacimiento() { return fechaNacimiento; }
	public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
	
}

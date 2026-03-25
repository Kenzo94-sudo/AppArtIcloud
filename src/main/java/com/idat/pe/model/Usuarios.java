package com.idat.pe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id_usuario;
	private String nombre;
	private String password;
	@Column(unique = true)
	private String email;
	private String direccion;
	private int telefono;
	private java.util.Date Fecharegistro;
	
	public Usuarios() {}

	public Usuarios(int id_usuario, String nombre, String password, String email, String direccion, int telefono,
			Date fecharegistro) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		Fecharegistro = fecharegistro;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public java.util.Date getFecharegistro() {
		return Fecharegistro;
	}

	public void setFecharegistro(java.util.Date fecharegistro) {
		Fecharegistro = fecharegistro;
	}

	
		
	
}

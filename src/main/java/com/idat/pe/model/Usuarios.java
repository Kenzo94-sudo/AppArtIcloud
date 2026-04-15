package com.idat.pe.model;

<<<<<<< HEAD
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
=======
import java.util.Date;
>>>>>>> 1709edb (FINAL COMMIT)

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
<<<<<<< HEAD
	@Column(name = "idUsuario")
	private int idUsuario;
=======
	@Column(name = "id_usuario")
	private int id_usuario;
>>>>>>> 1709edb (FINAL COMMIT)
	private String nombre;
	@Column(unique = true)
	private String password;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String direccion;
	@Column(unique = true)
<<<<<<< HEAD
	private String telefono;
	@Column(name = "fechaRegistro")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime fechaRegistro;
	
	public Usuarios() {}

	public Usuarios(int idUsuario, String nombre, String password, String email, String direccion, String telefono,
			LocalDateTime fechaRegistro) {
		super();
		this.idUsuario = idUsuario;
=======
	private int telefono;
	private java.util.Date Fecharegistro;
	
	public Usuarios() {}

	public Usuarios(int id_usuario, String nombre, String password, String email, String direccion, int telefono,
			Date fecharegistro) {
		super();
		this.id_usuario = id_usuario;
>>>>>>> 1709edb (FINAL COMMIT)
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
<<<<<<< HEAD
		this.fechaRegistro = fechaRegistro;
	}

	public int getId_usuario() {
		return idUsuario;
	}

	public void setId_usuario(int idUsuario) {
		this.idUsuario = idUsuario;
=======
		Fecharegistro = fecharegistro;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
>>>>>>> 1709edb (FINAL COMMIT)
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

<<<<<<< HEAD
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDateTime getfechaRegistro() {
		return fechaRegistro;
	}

	public void setfechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
=======
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
>>>>>>> 1709edb (FINAL COMMIT)
	}	
}

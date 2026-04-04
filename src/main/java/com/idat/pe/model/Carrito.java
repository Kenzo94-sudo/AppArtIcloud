package com.idat.pe.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCarrito" )
	private int idCarrito;
	@ManyToOne
	@JoinColumn(name = "fkUsuario")
	private Usuarios usuario;
	@Column(name = "fechaRegistro")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private Date fechaCompra;
	
	public Carrito() {}

	public Carrito(int idCarrito, Usuarios usuario, Date fechaCompra) {
		super();
		this.idCarrito = idCarrito;
		this.usuario = usuario;
		this.fechaCompra = fechaCompra;
	}

	public int getId_carrito() {
		return idCarrito;
	}

	public void setId_carrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public java.util.Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(java.util.Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

		
	
}

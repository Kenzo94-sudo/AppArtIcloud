package com.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle")
	private int id_detalle;
	
	@ManyToOne
	@JoinColumn(name = "id_carrito")
	private Carrito carrito;
	@ManyToOne
	@JoinColumn(name = "id_obra")
	private Obras obras;
	private int cantidad;
	private float precio;
	
	public CarritoDetalle() {}

	public CarritoDetalle(int id_detalle, Carrito carrito, Obras obras, int cantidad, float precio) {
		super();
		this.id_detalle = id_detalle;
		this.carrito = carrito;
		this.obras = obras;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Obras getObras() {
		return obras;
	}

	public void setObras(Obras obras) {
		this.obras = obras;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
	
}

package com.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidoDetalle")
public class PedidoDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id_detalle;
	@OneToOne
	@JoinColumn(name = "id_pedido")
	private int id_pedido;
	@OneToOne
	@JoinColumn(name = "id_obra")
	private int id_obra;
	private int cantidad;
	private float precio;
	
	public PedidoDetalle() {}

	public PedidoDetalle(int id_detalle, int id_pedido, int id_obra, int cantidad, float precio) {
		super();
		this.id_detalle = id_detalle;
		this.id_pedido = id_pedido;
		this.id_obra = id_obra;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getId_obra() {
		return id_obra;
	}

	public void setId_obra(int id_obra) {
		this.id_obra = id_obra;
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

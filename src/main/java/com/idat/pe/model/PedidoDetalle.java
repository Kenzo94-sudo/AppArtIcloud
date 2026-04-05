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
	private int idPedidoDetalle;
	@OneToOne
	@JoinColumn(name = "fkPedido")
	private Pedidos pedido;
	@OneToOne
	@JoinColumn(name = "fkObra")
	private Obras obra;
	private int cantidad;
	private float precio;
	
	public PedidoDetalle() {}

	public PedidoDetalle(int idPedidoDetalle, Pedidos pedido, Obras obra, int cantidad, float precio) {
		super();
		this.idPedidoDetalle = idPedidoDetalle;
		this.pedido = pedido;
		this.obra = obra;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId_detalle() {
		return idPedidoDetalle;
	}

	public void setId_detalle(int idPedidoDetalle) {
		this.idPedidoDetalle = idPedidoDetalle;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Obras getObra() {
		return obra;
	}

	public void setObra(Obras obra) {
		this.obra = obra;
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

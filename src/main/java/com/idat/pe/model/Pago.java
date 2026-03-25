package com.idat.pe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
	private int id_pago;
	@ManyToOne
	private Pedidos pedido;
	@ManyToOne
	private Usuarios usuario;
	private float precio;
	private MetodoPago metodoPago;
	private String estado;
	private java.util.Date fechaPago;
	
	public Pago() {
		// TODO Auto-generated constructor stub
	}

	public Pago(int id_pago, Pedidos pedido, Usuarios usuario, float precio, MetodoPago metodoPago, String estado,
			Date fechaPago) {
		super();
		this.id_pago = id_pago;
		this.pedido = pedido;
		this.usuario = usuario;
		this.precio = precio;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.fechaPago = fechaPago;
	}

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.util.Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(java.util.Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
}

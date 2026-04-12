package com.idat.pe.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPago")
	private int idPago;
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedidos pedido;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuarios usuario;
	private float precio;
	@Enumerated(EnumType.STRING)
	@Column(name = "metodo_pago")
	private MetodoPago metodoPago;
	private String estado;
	@Column(name = "fechaRegistro")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private Date fechaPago;
	
	public Pago() {}

	public Pago(int idPago, Pedidos pedido, Usuarios usuario, float precio, MetodoPago metodoPago, String estado,
			Date fechaPago) {
		super();
		this.idPago = idPago;
		this.pedido = pedido;
		this.usuario = usuario;
		this.precio = precio;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.fechaPago = fechaPago;
	}

	public int getId_pago() {
		return idPago;
	}

	public void setId_pago(int idPago) {
		this.idPago = idPago;
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

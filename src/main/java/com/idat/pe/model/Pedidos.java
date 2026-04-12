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
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private int idPedido;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuarios usuario;
	@ManyToOne
	@JoinColumn(name = "idObra")
	private Obras obra;
	@Column(name = "fechaRegistro")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private Date fechaPedido;
	private float total;
	private String estado;
	
	public Pedidos() {}

	public Pedidos(int idPedido, Usuarios usuario, Obras obra, Date fechaPedido, float total, String estado) {
		super();
		this.idPedido = idPedido;
		this.usuario = usuario;
		this.obra = obra;
		this.fechaPedido = fechaPedido;
		this.total = total;
		this.estado = estado;
	}

	public int getId_pedidos() {
		return idPedido;
	}

	public void setId_pedidos(int idPedido) {
		this.idPedido = idPedido;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Obras getObra() {
		return obra;
	}

	public void setObra(Obras obra) {
		this.obra = obra;
	}

	public java.util.Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(java.util.Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
	
	
	
package com.idat.pe.model;

import java.util.Date;

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
	@Column(name = "id_pedido")
	private int id_pedidos;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuarios usuario;
	@ManyToOne
	@JoinColumn(name = "id_obra")
	private Obras obra;
	private java.util.Date fechaPedido;
	private float total;
	private String estado;
	
	public Pedidos() {
		// TODO Auto-generated constructor stub
	}

	public Pedidos(int id_pedidos, Usuarios usuario, Obras obra, Date fechaPedido, float total, String estado) {
		super();
		this.id_pedidos = id_pedidos;
		this.usuario = usuario;
		this.obra = obra;
		this.fechaPedido = fechaPedido;
		this.total = total;
		this.estado = estado;
	}

	public int getId_pedidos() {
		return id_pedidos;
	}

	public void setId_pedidos(int id_pedidos) {
		this.id_pedidos = id_pedidos;
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
	
	
	
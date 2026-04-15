package com.idat.pe.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;
	@ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;
	@ManyToOne
	@JoinColumn(name = "idObra")
	private Obras obra;
	@Column(name = "fecha_pedido")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime fechaPedido;
	private double total;
	private String estado;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalle> detalles;
	
	public Pedidos() {}

	public Pedidos(int idPedido, Usuarios usuario, Obras obra, LocalDateTime fechaPedido, float total, String estado) {
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

	public LocalDateTime getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDateTime fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
	
	
	
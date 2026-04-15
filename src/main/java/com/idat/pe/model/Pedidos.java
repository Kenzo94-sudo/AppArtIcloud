package com.idat.pe.model;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
=======
import java.util.Date;

>>>>>>> 1709edb (FINAL COMMIT)
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
import jakarta.persistence.OneToMany;
=======
>>>>>>> 1709edb (FINAL COMMIT)
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
<<<<<<< HEAD
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
=======
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
>>>>>>> 1709edb (FINAL COMMIT)
		this.usuario = usuario;
		this.obra = obra;
		this.fechaPedido = fechaPedido;
		this.total = total;
		this.estado = estado;
	}

	public int getId_pedidos() {
<<<<<<< HEAD
		return idPedido;
	}

	public void setId_pedidos(int idPedido) {
		this.idPedido = idPedido;
=======
		return id_pedidos;
	}

	public void setId_pedidos(int id_pedidos) {
		this.id_pedidos = id_pedidos;
>>>>>>> 1709edb (FINAL COMMIT)
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

<<<<<<< HEAD
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
=======
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
>>>>>>> 1709edb (FINAL COMMIT)
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
	
	
	
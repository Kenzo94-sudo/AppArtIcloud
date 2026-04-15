package com.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = false)
    private Obras obra;

    private int cantidad;
    private double precio;
	
	public PedidoDetalle() {}

	public PedidoDetalle(int idDetalle, Pedidos pedido, Obras obra, int cantidad, float precio) {
		super();
		this.idDetalle = idDetalle;
		this.pedido = pedido;
		this.obra = obra;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId_detalle() {
		return idDetalle;
	}

	public void setId_detalle(int idDetalle) {
		this.idDetalle = idDetalle;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double d) {
		this.precio = d;
	}
	
	
}
=======
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidoDetalle")
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id_detalle;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "id_obra")
    private Obras obra;

    private int cantidad;
    private float precio;

    public PedidoDetalle() {}

    public PedidoDetalle(int id_detalle, Pedidos pedido, Obras obra, int cantidad, float precio) {
        this.id_detalle = id_detalle;
        this.pedido = pedido;
        this.obra = obra;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId_detalle() { return id_detalle; }
    public void setId_detalle(int id_detalle) { this.id_detalle = id_detalle; }

    public Pedidos getPedido() { return pedido; }
    public void setPedido(Pedidos pedido) { this.pedido = pedido; }

    public Obras getObra() { return obra; }
    public void setObra(Obras obra) { this.obra = obra; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }
}
>>>>>>> 1709edb (FINAL COMMIT)

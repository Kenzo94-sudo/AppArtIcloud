package com.idat.pe.model;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritoDetalle")
public class CarritoDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCarritoDetalle")
	private int idCarritoDetalle;
	@ManyToOne
	@JoinColumn(name = "idCarrito")
	private Carrito carrito;
	@ManyToOne
	@JoinColumn(name = "idObra")
	private Obras obras;
	private int cantidad;
	private float precio;
	
	public CarritoDetalle() {}

	public CarritoDetalle(int idCarritoDetalle, Carrito carrito, Obras obras, int cantidad, float precio) {
		super();
		this.idCarritoDetalle = idCarritoDetalle;
		this.carrito = carrito;
		this.obras = obras;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId_detalle() {
		return idCarritoDetalle;
	}

	public void setId_detalle(int idCarritoDetalle) {
		this.idCarritoDetalle = idCarritoDetalle;
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
=======
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
    @JsonIgnoreProperties({"carritoDetalles", "usuario", "hibernateLazyInitializer"})
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "id_obra")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Obras obras;

    private int cantidad;
    private float precio;

    public CarritoDetalle() {}

    public CarritoDetalle(int id_detalle, Carrito carrito, Obras obras, int cantidad, float precio) {
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
>>>>>>> 1709edb (FINAL COMMIT)

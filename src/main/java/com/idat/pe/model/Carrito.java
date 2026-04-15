package com.idat.pe.model;

import java.util.Date;

<<<<<<< HEAD
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.persistence.OneToOne;
=======
>>>>>>> 1709edb (FINAL COMMIT)
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
<<<<<<< HEAD
		
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idCarrito")
	    private int idCarrito;
	
	    @ManyToOne
	    @JoinColumn(name = "idUsuario", nullable = false)
	    private Usuarios usuario;
	
	    @Column(name = "fechaRegistro", updatable = false)
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @CreationTimestamp
	    private Date fechaCompra;
		
	public Carrito() {}

	public Carrito(int idCarrito, Usuarios usuario, Date fechaCompra) {
		super();
		this.idCarrito = idCarrito;
		this.usuario = usuario;
		this.fechaCompra = fechaCompra;
	}

	public int getId_carrito() {
		return idCarrito;
	}

	public void setId_carrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public java.util.Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(java.util.Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

		
	
}
=======

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private int id_carrito;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
    private Usuarios usuario;

    private java.util.Date fechaCompra;

    public Carrito() {}

    public Carrito(int id_carrito, Usuarios usuario, Date fechaCompra) {
        this.id_carrito = id_carrito;
        this.usuario = usuario;
        this.fechaCompra = fechaCompra;
    }

    public int getId_carrito() {
    	return id_carrito;
    }
    public void setId_carrito(int id_carrito) {
    	this.id_carrito = id_carrito;
    }
    public Usuarios getUsuario() { return usuario;
    }
    public void setUsuario(Usuarios usuario) {
    	this.usuario = usuario;
    }
    public java.util.Date getFechaCompra() {
    	return fechaCompra;
    }
    public void setFechaCompra(java.util.Date fechaCompra) {
    	this.fechaCompra = fechaCompra;
    }
}
>>>>>>> 1709edb (FINAL COMMIT)

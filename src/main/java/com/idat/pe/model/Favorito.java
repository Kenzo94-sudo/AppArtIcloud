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
import jakarta.persistence.Table;
<<<<<<< HEAD


@Entity
@Table(name = "favoritos")
public class Favorito {
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "idFavorito")
		    private int idFavorito;
		
		    @ManyToOne
		    @JoinColumn(name = "idUsuario", nullable = false)
		    private Usuarios usuario;
		
		    @ManyToOne
		    @JoinColumn(name = "idObra", nullable = false)
		    private Obras obra;
		
		    @Column(name = "fechaRegistro", updatable = false)
		    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		    @CreationTimestamp
		    private Date fecha;
		
		public Favorito() {}

		public Favorito(int idFavorito, Usuarios usuario, Obras obra, Date fecha) {
			super();
			this.idFavorito = idFavorito;
			this.usuario = usuario;
			this.obra = obra;
			this.fecha = fecha;
		}

		public int getId_favorito() {
			return idFavorito;
		}

		public void setId_favorito(int idFavorito) {
			this.idFavorito = idFavorito;
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

		public java.util.Date getFecha() {
			return fecha;
		}

		public void setFecha(java.util.Date fecha) {
			this.fecha = fecha;
		}		
		
}
=======
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "favoritos",
    uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_obra"}))
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorito")
    private int id_favorito;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_obra")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Obras obra;

    private java.util.Date fecha;

    public Favorito() {}

    public Favorito(int id_favorito, Usuarios usuario, Obras obra, Date fecha) {
        this.id_favorito = id_favorito;
        this.usuario = usuario;
        this.obra = obra;
        this.fecha = fecha;
    }

    public int getId_favorito() {
    	return id_favorito;
    }
    public void setId_favorito(int id_favorito) {
    	this.id_favorito = id_favorito; 
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
    public java.util.Date getFecha() {
    	return fecha; 
    }
    public void setFecha(java.util.Date fecha) { 
    	this.fecha = fecha; 
    }
}
>>>>>>> 1709edb (FINAL COMMIT)

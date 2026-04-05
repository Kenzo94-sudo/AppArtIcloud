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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "favoritos",
uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_obra"}))
public class Favorito {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idFavorito")
		private int idFavorito;
		@ManyToOne
		@JoinColumn(name = "fkUsuario")
		private Usuarios usuario;
		@ManyToOne
		@JoinColumn(name = "fkObra")
		private Obras obra;
		@Column(name = "fechaRegistro")
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

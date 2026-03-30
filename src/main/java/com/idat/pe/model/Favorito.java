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
		private Usuarios usuario;
		@ManyToOne
		@JoinColumn(name = "id_obra")
		private Obras obra;
		private java.util.Date fecha;
		
		public Favorito() {}

		public Favorito(int id_favorito, Usuarios usuario, Obras obra, Date fecha) {
			super();
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

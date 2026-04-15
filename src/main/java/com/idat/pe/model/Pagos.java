package com.idat.pe.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "pagos")
	public class Pagos {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idPago")
	    private int idPago;

	    @ManyToOne
	    @JoinColumn(name = "idPedido", nullable = false)
	    private Pedidos pedido;

	    // Si decides mantenerlo para reportes directos:
	    @ManyToOne
	    @JoinColumn(name = "idUsuario", nullable = false)
	    private Usuarios usuario;

	    private double monto;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "metodo_pago")
	    private MetodoPago metodoPago;

	    private String estado; // Ejemplo: "COMPLETADO", "RECHAZADO"

	    @Column(name = "fechaRegistro", updatable = false)
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @CreationTimestamp
	    private LocalDateTime fechaPago;
	
	    public Pagos() {
			// TODO Auto-generated constructor stub
		}

		public Pagos(int idPago, Pedidos pedido, Usuarios usuario, double monto, MetodoPago metodoPago, String estado,
				LocalDateTime fechaPago) {
			super();
			this.idPago = idPago;
			this.pedido = pedido;
			this.usuario = usuario;
			this.monto = monto;
			this.metodoPago = metodoPago;
			this.estado = estado;
			this.fechaPago = fechaPago;
		}

		public int getIdPago() {
			return idPago;
		}

		public void setIdPago(int idPago) {
			this.idPago = idPago;
		}

		public Pedidos getPedido() {
			return pedido;
		}

		public void setPedido(Pedidos pedido) {
			this.pedido = pedido;
		}

		public Usuarios getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuarios usuario) {
			this.usuario = usuario;
		}

		public double getMonto() {
			return monto;
		}

		public void setMonto(double monto) {
			this.monto = monto;
		}

		public MetodoPago getMetodoPago() {
			return metodoPago;
		}

		public void setMetodoPago(MetodoPago metodoPago) {
			this.metodoPago = metodoPago;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public LocalDateTime getFechaPago() {
			return fechaPago;
		}

		public void setFechaPago(LocalDateTime fechaPago) {
			this.fechaPago = fechaPago;
		}


	    
}



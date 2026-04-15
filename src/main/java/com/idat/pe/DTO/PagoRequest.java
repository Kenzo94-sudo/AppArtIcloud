package com.idat.pe.DTO;

import com.idat.pe.model.MetodoPago;

public class PagoRequest {
	private int idPedido;
    private double monto;
    private MetodoPago metodoPago;
    
    public PagoRequest() {
		// TODO Auto-generated constructor stub
	}

	public PagoRequest(int idPedido, double monto, MetodoPago metodoPago) {
		super();
		this.idPedido = idPedido;
		this.monto = monto;
		this.metodoPago = metodoPago;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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
    
	
}

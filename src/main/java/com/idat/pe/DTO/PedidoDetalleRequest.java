package com.idat.pe.DTO;

public class PedidoDetalleRequest {
	private int idObra;
    private int cantidad;
    private double precio;
    
    public PedidoDetalleRequest() {
		// TODO Auto-generated constructor stub
	}

	public PedidoDetalleRequest(int idObra, int cantidad, double precio) {
		super();
		this.idObra = idObra;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
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

	public void setPrecio(double precio) {
		this.precio = precio;
	}
    
    
}

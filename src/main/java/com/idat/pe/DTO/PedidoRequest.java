package com.idat.pe.DTO;

import java.util.List;

public class PedidoRequest {

	private int idUsuario;
    private double total;
    private List <PedidoDetalleRequest> detalle;
    
    
   public PedidoRequest() {
	// TODO Auto-generated constructor stub
   }


   public PedidoRequest(int idUsuario, double total, List<PedidoDetalleRequest> detalle) {
	super();
	this.idUsuario = idUsuario;
	this.total = total;
	this.detalle = detalle;
   }


   public int getIdUsuario() {
	return idUsuario;
   }


   public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
   }


   public double getTotal() {
	return total;
   }


   public void setTotal(double total) {
	this.total = total;
   }


   public List<PedidoDetalleRequest> getDetalle() {
	return detalle;
   }


   public void setDetalle(List<PedidoDetalleRequest> detalle) {
	this.detalle = detalle;
   }
   
   
   
}

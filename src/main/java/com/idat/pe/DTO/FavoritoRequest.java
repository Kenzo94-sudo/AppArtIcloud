package com.idat.pe.DTO;


public class FavoritoRequest {
    private int idUsuario;
    private int idObra;
    
    public FavoritoRequest() {
		// TODO Auto-generated constructor stub
	}

	public FavoritoRequest(int idUsuario, int idObra) {
		super();
		this.idUsuario = idUsuario;
		this.idObra = idObra;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}
    
     
}
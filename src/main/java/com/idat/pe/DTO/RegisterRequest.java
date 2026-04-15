package com.idat.pe.DTO;

public class RegisterRequest {

	private String nombre;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    
    
   public RegisterRequest() {
	// TODO Auto-generated constructor stub
}


   public RegisterRequest(String nombre, String email, String password, String telefono, String direccion) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.password = password;
	this.telefono = telefono;
	this.direccion = direccion;
   }


   public String getNombre() {
	return nombre;
   }


   public void setNombre(String nombre) {
	this.nombre = nombre;
   }


   public String getEmail() {
	return email;
   }


   public void setEmail(String email) {
	this.email = email;
   }


   public String getPassword() {
	return password;
   }


   public void setPassword(String password) {
	this.password = password;
   }


   public String getTelefono() {
	return telefono;
   }


   public void setTelefono(String telefono) {
	this.telefono = telefono;
   }


   public String getDireccion() {
	return direccion;
   }


   public void setDireccion(String direccion) {
	this.direccion = direccion;
   }
   
}

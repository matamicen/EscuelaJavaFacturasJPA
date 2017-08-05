package com.example.facturas.demoFacturas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private long iduser;
	private String nombre;
	private String password;
	
	@OneToMany(mappedBy="usuario")
	private List<Factura> factura;

	public Usuario(long iduser, String nombre, String password) {
		super();
		this.iduser = iduser;
		this.nombre = nombre;
		this.password = password;
	
	}

	public Usuario() {
		super();
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Factura> getFactura() {
		return factura;
	}

	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}


	
	

}

package com.example.facturas.demoFacturas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue
	private long idprod;
	
	private String nombre;
	private float precio;
	
	@OneToMany(mappedBy="producto")
	private List<Items> items;
	
	public Producto(long idprod, String nombre, float precio) {
		super();
		this.idprod = idprod;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto() {
		super();
	}

	public long getIdprod() {
		return idprod;
	}

	public void setIdprod(long idprod) {
		this.idprod = idprod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
	
	
	

}

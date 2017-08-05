package com.example.facturas.demoFacturas.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue
	private Long idfac;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="factura")
	private List<Items> items;
	
	public Factura(Long idfac, Date fecha, Cliente cliente) {
		super();
		this.idfac = idfac;
		this.fecha = fecha;
		this.cliente = cliente;
	}
	public Factura() {
		super();
	}
	public Long getIdfac() {
		return idfac;
	}
	public void setIdfac(Long idfac) {
		this.idfac = idfac;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
	

}

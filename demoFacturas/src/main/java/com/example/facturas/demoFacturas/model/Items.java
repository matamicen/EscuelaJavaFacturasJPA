package com.example.facturas.demoFacturas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Items {
	
	@Id
	@GeneratedValue
	private long iditem;
	
	@ManyToOne
	@JoinColumn(name = "factura_id")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	private int qty;
	
	public Items(Factura factura, Producto producto, int qty) {
		super();
		
		this.factura = factura;
		this.producto = producto;
		this.qty = qty;
	}

	public Items() {
		super();
	}

	public long getIditem() {
		return iditem;
	}

	public void setIditem(long iditem) {
		this.iditem = iditem;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	
	

}

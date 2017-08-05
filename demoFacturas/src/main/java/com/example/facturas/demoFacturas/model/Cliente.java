package com.example.facturas.demoFacturas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long idcli;
	private String nombre;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;
	
	public Cliente(Long idcli, String nombre) {
		super();
		this.idcli = idcli;
		this.nombre = nombre;
	}

	public Cliente() {
		super();
	}

	public Long getIdcli() {
		return idcli;
	}

	public void setIdcli(Long idcli) {
		this.idcli = idcli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	
	

}

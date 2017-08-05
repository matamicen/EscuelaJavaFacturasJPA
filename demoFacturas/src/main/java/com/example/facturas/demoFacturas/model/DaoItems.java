package com.example.facturas.demoFacturas.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoItems extends CrudRepository<Items, Long> {
	
	public List<Items> findByfactura(Factura fac);

}

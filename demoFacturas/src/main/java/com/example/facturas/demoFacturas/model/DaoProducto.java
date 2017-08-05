package com.example.facturas.demoFacturas.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoProducto extends CrudRepository<Producto, Long> {

}

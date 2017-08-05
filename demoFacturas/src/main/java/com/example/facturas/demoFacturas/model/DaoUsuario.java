package com.example.facturas.demoFacturas.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoUsuario extends CrudRepository<Usuario, Long> {
	
	public List<Usuario> findBynombre(String nombre);

}

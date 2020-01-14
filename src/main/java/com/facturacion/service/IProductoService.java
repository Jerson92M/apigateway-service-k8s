package com.facturacion.service;

import org.springframework.http.ResponseEntity;

public interface IProductoService {

	public ResponseEntity<?> getAll(String codigo);

	public ResponseEntity<?> add(String producto);

	public ResponseEntity<?> update(Integer id, String producto);

	public ResponseEntity<?> delete(Integer id);
	
}

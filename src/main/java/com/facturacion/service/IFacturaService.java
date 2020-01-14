package com.facturacion.service;

import org.springframework.http.ResponseEntity;

public interface IFacturaService {
	
	public ResponseEntity<?> add(String factura);
	
}

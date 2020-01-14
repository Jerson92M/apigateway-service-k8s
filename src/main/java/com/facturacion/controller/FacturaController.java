package com.facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.service.IFacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

	@Autowired
	IFacturaService service;
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody String factura){
		System.out.println(factura);
		return service.add(factura);
	}
}

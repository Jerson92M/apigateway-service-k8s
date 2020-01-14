package com.facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	IProductoService service;
	
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam( required = false) String codigo){
		
		ResponseEntity<?> productos =  service.getAll(codigo);
		
		return productos;
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody String producto){
	
		return service.add(producto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody String producto){
		
		return service.update(id, producto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		return service.delete(id);
	}
}

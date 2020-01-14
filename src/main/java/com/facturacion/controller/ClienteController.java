package com.facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.facturacion.service.IClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	IClienteService service;
	
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam( required = false) String identificacion){
		
		ResponseEntity<?> clientes =  service.getAll(identificacion);
		
		return clientes;
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestPart(required = false) MultipartFile imagen,
								 @RequestPart(required = false) String cliente) throws JsonMappingException, JsonProcessingException {
		
		return service.add(imagen, cliente);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, 
									@RequestPart(required = false) MultipartFile imagen,
									@RequestPart(required = false) String cliente) throws JsonMappingException, JsonProcessingException{

		return service.update(id, imagen, cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		return service.delete(id);
	}
	
	
}

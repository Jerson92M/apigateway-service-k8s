package com.facturacion.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IClienteService {

	public ResponseEntity<?> getAll(String identificacion);

	public ResponseEntity<?> add(MultipartFile imagen, String cliente) throws JsonMappingException, JsonProcessingException;

	public ResponseEntity<?> update(Integer id, MultipartFile imagen, String cliente) throws JsonMappingException, JsonProcessingException;

	public ResponseEntity<?> delete(Integer id);

}

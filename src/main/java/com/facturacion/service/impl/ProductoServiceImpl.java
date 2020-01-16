package com.facturacion.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.facturacion.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ResponseEntity<?> getAll(String codigo) {

		String uri;
	
		if (codigo == null || codigo.isEmpty()) {
			uri = "http://productos-service:8082/productos";
		} else {
			uri = "http://productos-service:8082/productos?codigo="+codigo;
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	}

	@Override
	public ResponseEntity<?> add(String producto) {
		
		final String uri = "http://productos-service:8082/productos";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(producto, headers);
		
		return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}

	@Override
	public ResponseEntity<?> update(Integer id, String producto) {
		
		final String uri = "http://productos-service:8082/productos/"+id;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(producto, headers);

		return restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		
		final String uri = "http://productos-service:8082/productos/"+id;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
	}

}

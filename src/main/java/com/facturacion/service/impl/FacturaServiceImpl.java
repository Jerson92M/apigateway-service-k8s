package com.facturacion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.facturacion.service.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<?> add(String factura) {
		
		final String uri = "http://facturas-service/facturas";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(factura, headers);
		
		return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}
	
	
}

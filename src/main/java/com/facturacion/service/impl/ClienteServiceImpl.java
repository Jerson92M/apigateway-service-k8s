package com.facturacion.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.facturacion.service.IClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<?> getAll(String identificacion) {
		
		String uri;
		
		if (identificacion == null || identificacion.isEmpty()) {
			uri = "http://clientes-service:8081/clientes";
		} else {
			uri = "http://clientes-service:8081/clientes?identificacion="+identificacion;
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	}

	@Override
	public ResponseEntity<?> add(MultipartFile imagen, String cliente) throws JsonMappingException, JsonProcessingException {
		
		final String uri = "http://clientes-service:8081/clientes";

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonCliente = mapper.readTree(cliente);
	    
	    if (imagen != null) {
	    	body.add("imagen", imagen.getResource());
	    }
		body.add("cliente", jsonCliente);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);
	
		return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		
	}

	@Override
	public ResponseEntity<?> update( Integer id, MultipartFile imagen, String cliente) throws JsonMappingException, JsonProcessingException {
		
		final String uri = "http://clientes-service:8081/clientes/"+id;
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonCliente = mapper.readTree(cliente);
	    
	    if (imagen != null) {
	    	body.add("imagen", imagen.getResource());
	    }
		body.add("cliente", jsonCliente);
		body.add("id", id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);

		return restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		
		final String uri = "http://clientes-service:8081/clientes/"+id;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
	}

}

package com.facturacion.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Tipo de identificación requerido")
	private String tipoIdentificacion;
	
	@NotBlank(message = "Identificación requerida")
	private String identificacion;
	
	@NotBlank(message = "Nombres requerido")
	private String nombres;
	
	@NotBlank(message = "Apellidos requerido")
	private String apellidos;
	
	private String direccionResidencia;
	
	private int edad;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String foto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}

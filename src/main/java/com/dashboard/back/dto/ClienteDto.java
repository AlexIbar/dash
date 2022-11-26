package com.dashboard.back.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dashboard.back.model.Venta_encabezado;

public class ClienteDto {
	private Integer id_cliente;
	
	@NotEmpty
	@Size(min=7, max = 11, message = "Las cedula del cliente como minimo debe tener 7 caracteres y masxímo 11")
	private String cedula_cliente;
	
	@NotEmpty
	@Size(min=3, max=50, message="El nombre debe tener como minimo 3 caracteres y máximo 50")
	private String nombre_cliente;
	
	@NotEmpty
	@Size(min=7, max=10, message="El numero marcado no corresponde a un numero de celular o telefono")
	private String celular;
	
	private List<Venta_encabezado> ventas_encabezado;
	

	public List<Venta_encabezado> getVentas_encabezado() {
		return ventas_encabezado;
	}

	public void setVentas_encabezado(List<Venta_encabezado> ventas_encabezado) {
		this.ventas_encabezado = ventas_encabezado;
	}

	
	
	public ClienteDto(Integer id_cliente,
			@NotEmpty @Size(min = 7, max = 11, message = "Las cedula del cliente como minimo debe tener 7 caracteres y masxímo 11") String cedula_cliente,
			@NotEmpty @Size(min = 3, max = 50, message = "El nombre debe tener como minimo 3 caracteres y máximo 50") String nombre_cliente,
			@NotEmpty @Size(min = 7, max = 10, message = "El numero marcado no corresponde a un numero de celular o telefono") String celular,
			List<Venta_encabezado> ventas_encabezado) {
		super();
		this.id_cliente = id_cliente;
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.celular = celular;
		this.ventas_encabezado = ventas_encabezado;
	}
	
	public ClienteDto(
			@NotEmpty @Size(min = 7, max = 11, message = "Las cedula del cliente como minimo debe tener 7 caracteres y masxímo 11") String cedula_cliente,
			@NotEmpty @Size(min = 3, max = 50, message = "El nombre debe tener como minimo 3 caracteres y máximo 50") String nombre_cliente,
			@NotEmpty @Size(min = 7, max = 10, message = "El numero marcado no corresponde a un numero de celular o telefono") String celular,
			List<Venta_encabezado> ventas_encabezado) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.celular = celular;
		this.ventas_encabezado = ventas_encabezado;
	}
	public ClienteDto(
			@NotEmpty @Size(min = 7, max = 11, message = "Las cedula del cliente como minimo debe tener 7 caracteres y masxímo 11") String cedula_cliente,
			@NotEmpty @Size(min = 3, max = 50, message = "El nombre debe tener como minimo 3 caracteres y máximo 50") String nombre_cliente,
			@NotEmpty @Size(min = 7, max = 10, message = "El numero marcado no corresponde a un numero de celular o telefono") String celular
			) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.celular = celular;
	}
	public ClienteDto() {}
	
	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}

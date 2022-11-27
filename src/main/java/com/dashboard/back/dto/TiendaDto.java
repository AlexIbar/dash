package com.dashboard.back.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dashboard.back.model.Ciudad;

public class TiendaDto {
	private Integer id_tienda;
	
	@NotEmpty()
	@Size(min=1, message="Centro de costos no puede estar vacio")
	private String centro_costos;
	
	@NotEmpty()
	@Size(min=3, message="El nombre requiere como minimo 3 caracteres")
	private String nombre;
	
	@NotEmpty()
	@Size(min=1, message="Es necesario asignar una ciudad")
	private int id_ciudad;
	
	private Ciudad ciudad;

	public TiendaDto(Integer id_tienda,
			@NotEmpty @Size(min = 1, message = "Centro de costos no puede estar vacio") String centro_costos,
			@NotEmpty @Size(min = 3, message = "El nombre requiere como minimo 3 caracteres") String nombre,
			@NotEmpty @Size(min = 1, message = "Es necesario asignar una ciudad") int id_ciudad, Ciudad ciudad) {
		super();
		this.id_tienda = id_tienda;
		this.centro_costos = centro_costos;
		this.nombre = nombre;
		this.id_ciudad = id_ciudad;
		this.ciudad = ciudad;
	}

	public TiendaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(Integer id_tienda) {
		this.id_tienda = id_tienda;
	}

	public String getCentro_costos() {
		return centro_costos;
	}

	public void setCentro_costos(String centro_costos) {
		this.centro_costos = centro_costos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}

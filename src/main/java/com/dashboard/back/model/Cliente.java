package com.dashboard.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;
	
	private String cedula_cliente;
	
	private String nombre_cliente;
	
	private String celular;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Venta_encabezado> ventas_encabezado;

	public List<Venta_encabezado> getVentas_encabezado() {
		return ventas_encabezado;
	}

	public void setVentas_encabezado(List<Venta_encabezado> ventas_encabezado) {
		this.ventas_encabezado = ventas_encabezado;
	}

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

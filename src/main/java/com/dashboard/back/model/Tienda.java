package com.dashboard.back.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tiendas")
public class Tienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tienda;
	
	@Column(unique=true)
	private String centro_costos;
	
	@Column(unique=true)
	private String nombre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ciudad")
	@JsonIgnore
	private Ciudad ciudad;
	
	@OneToMany(mappedBy = "tienda")
	@JsonIgnore
	private List<Venta_encabezado> ventas_encabezado;
	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad coidad) {
		this.ciudad = coidad;
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
	
	
	
}

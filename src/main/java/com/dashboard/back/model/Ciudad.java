package com.dashboard.back.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ciudades")
public class Ciudad {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id_ciudad;
	
	@Column(unique=true)
	private String nombre;
	
	@OneToMany(mappedBy = "ciudad")
	private List<Tienda> tiendas;

	public Integer getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}

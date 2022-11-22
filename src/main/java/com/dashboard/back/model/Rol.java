package com.dashboard.back.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rol;
	
	private String nombre_rol;
	
	private String des_rol;
	
	public Rol() {	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public String getDes_rol() {
		return des_rol;
	}

	public void setDes_rol(String des_rol) {
		this.des_rol = des_rol;
	}
	
	@ManyToMany(mappedBy = "roles")
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	
}

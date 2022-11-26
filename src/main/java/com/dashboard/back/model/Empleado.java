package com.dashboard.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

@Entity
@Table(name="Empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_empleado;
	
	private String cedula;
	
	private String nombre;
	
	private String email;
	
	private boolean activo;
	
	private String password;
	
	private String token_cambio;
	
	public Empleado() {}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken_cambio() {
		return token_cambio;
	}

	public void setToken_cambio(String token_cambio) {
		this.token_cambio = token_cambio;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="roles_empleados",
			joinColumns = {@JoinColumn(name="id_empleado")},
			inverseJoinColumns = {@JoinColumn(name="id_rol")}
	)
	private List<Rol> roles = new ArrayList<Rol>();

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	@OneToMany(mappedBy = "empleado")
	private List<Venta_encabezado> ventas_encabezado;
	
	
	
}

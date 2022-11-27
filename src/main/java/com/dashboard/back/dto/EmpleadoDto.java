package com.dashboard.back.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dashboard.back.model.Rol;

public class EmpleadoDto {
	
	private int id_empleado;
	
	@NotNull
	private String cedula;
	
	@NotNull
	private String nombre;
	
	@NotNull
	@Email
	private String email;
	
	private boolean activo;
	
	@NotNull
	@Size(min=8, max=20, message="Se deben tener minimo 8 caracteres y maximo 20")
	private String password;
	
	private String token_cambio;
	
	private int id_rol;
	
	private List<Rol> roles;

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

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
}

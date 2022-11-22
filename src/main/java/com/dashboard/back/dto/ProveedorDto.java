package com.dashboard.back.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dashboard.back.model.Producto;

public class ProveedorDto {
	
	private int id_proveedor;
	
	@NotEmpty
	@Size(min=7,message = "Se requiere como minimo un Nit de 7 caracteres")
	private String nit_proveedor;
	
	@NotEmpty
	@Size(min=3, message = "EL nombre debe tener como minimo 3 caracteres")
	private String nombre_proveedor;
	
	private List<Producto> productos;
	
	public ProveedorDto() {}
	
	public ProveedorDto(
			@NotEmpty @Size(min = 7, message = "Se requiere como minimo un Nit de 7 caracteres") String nit_proveedor,
			@NotEmpty @Size(min = 3, message = "EL nombre debe tener como minimo 3 caracteres") String nombre_proveedor,
			List<Producto> productosList
	) {
		super();
		this.nit_proveedor = nit_proveedor;
		this.nombre_proveedor = nombre_proveedor;
	}
	
	public ProveedorDto(
			@NotEmpty @Size(min = 7, message = "Se requiere como minimo un Nit de 7 caracteres") String nit_proveedor,
			@NotEmpty @Size(min = 3, message = "EL nombre debe tener como minimo 3 caracteres") String nombre_proveedor
	) {
		super();
		this.nit_proveedor = nit_proveedor;
		this.nombre_proveedor = nombre_proveedor;
	}

	public ProveedorDto(
			int id_proveedor,
			@NotEmpty @Size(min = 7, message = "Se requiere como minimo un Nit de 7 caracteres") String nit_proveedor,
			@NotEmpty @Size(min = 3, message = "EL nombre debe tener como minimo 3 caracteres") String nombre_proveedor,
			List<Producto> productosList
	) {
		super();
		this.id_proveedor = id_proveedor;
		this.nit_proveedor = nit_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.productos = productosList;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(String nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	
	
	
	
	
}

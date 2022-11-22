package com.dashboard.back.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dashboard.back.model.Proveedor;

public class ProductoDto {
	
	private Integer id_producto;
	
	@NotEmpty
	@Size(min=5, max=100, message = "Se requiere como minimo 5 caracteres y maximo 100")
	private String nombre_producto;
	
	@NotEmpty
	@Size(min=100, message = "El valor minimo por producto es de $100")
	private double valor_producto;
	
	
	private boolean activo;
	
	@NotEmpty
	@Size(min=100, message="El valor minimo por producto es de $100")
	private double costo;
	
	@NotEmpty
	@Size(min=1, message="Es necesario asignar un proveedor al producto")
	private int proveedorId;
	
	private Proveedor proveedor;

	public ProductoDto(Integer id_producto,
			@NotEmpty @Size(min = 5, max = 100, message = "Se requiere como minimo 5 caracteres y maximo 100") String nombre_producto,
			@NotEmpty @Size(min = 100, message = "El valor minimo por producto es de $100") double valor_producto,
			boolean activo,
			@NotEmpty @Size(min = 100, message = "El valor minimo por producto es de $100") double costo,
			@NotEmpty @Size(min = 1, message = "Es necesario asignar un proveedor al producto") int proveedorId,
			Proveedor proveedor) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.valor_producto = valor_producto;
		this.activo = activo;
		this.costo = costo;
		this.proveedorId = proveedorId;
		this.proveedor = proveedor;
	}
	
	public ProductoDto(
			@NotEmpty @Size(min = 5, max = 100, message = "Se requiere como minimo 5 caracteres y maximo 100") String nombre_producto,
			@NotEmpty @Size(min = 100, message = "El valor minimo por producto es de $100") double valor_producto,
			boolean activo,
			@NotEmpty @Size(min = 100, message = "El valor minimo por producto es de $100") double costo,
			@NotEmpty @Size(min = 1, message = "Es necesario asignar un proveedor al producto") int proveedorId
	) {
		super();
		this.nombre_producto = nombre_producto;
		this.valor_producto = valor_producto;
		this.activo = activo;
		this.costo = costo;
		this.proveedorId = proveedorId;
	}
	
	public ProductoDto() {}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public double getValor_producto() {
		return valor_producto;
	}

	public void setValor_producto(double valor_producto) {
		this.valor_producto = valor_producto;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(int proveedorId) {
		this.proveedorId = proveedorId;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
	
}

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

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_producto;
	
	private String nombre_producto;
	
	private double valor_producto;
	
	@Column(columnDefinition = "boolean default true")
	private boolean activo;
	
	private double costo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
	@OneToMany(mappedBy = "producto")
	private List<Venta_cuerpo> ventas_cuerpo;

	public Producto() {}

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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
}

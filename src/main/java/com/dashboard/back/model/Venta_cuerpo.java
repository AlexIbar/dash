package com.dashboard.back.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas_cuerpo")
public class Venta_cuerpo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ventas_cuerpo;
	
	private Integer cantidad;
	
	private double valor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ventas_encabezado")
	private Venta_encabezado venta_encabezado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_producto")
	private Producto producto;

	public Integer getId_ventas_cuerpo() {
		return id_ventas_cuerpo;
	}

	public void setId_ventas_cuerpo(Integer id_ventas_cuerpo) {
		this.id_ventas_cuerpo = id_ventas_cuerpo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Venta_encabezado getVenta_encabezado() {
		return venta_encabezado;
	}

	public void setVenta_encabezado(Venta_encabezado venta_encabezado) {
		this.venta_encabezado = venta_encabezado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}

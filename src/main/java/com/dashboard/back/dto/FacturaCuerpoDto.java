package com.dashboard.back.dto;

public class FacturaCuerpoDto {
	private int id_producto;
	
	private int cantidad;
	
	private double valor;

	public FacturaCuerpoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}

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
@Table(name="ventas_encabezado")
public class Venta_encabezado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	
	@Column(length = 5)
	private String des_num_factura;
	
	@Column(columnDefinition = "DATETIME")
	private String fecha_factura;
	
	
	private double valor_factura;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_tienda")
	private Tienda tienda;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_empleado")
	private Empleado empleado;
	
	@OneToMany(mappedBy = "venta_encabezado")
	private List<Venta_cuerpo> venta_cuerpo;

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getDes_num_factura() {
		return des_num_factura;
	}

	public void setDes_num_factura(String des_num_factura) {
		this.des_num_factura = des_num_factura;
	}

	public String getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public double getValor_factura() {
		return valor_factura;
	}

	public void setValor_factura(double valor_factura) {
		this.valor_factura = valor_factura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public List<Venta_cuerpo> getVenta_cuerpo() {
		return venta_cuerpo;
	}

	public void setVenta_cuerpo(List<Venta_cuerpo> venta_cuerpo) {
		this.venta_cuerpo = venta_cuerpo;
	}
	
	
	
}

package com.dashboard.back.dto;

import java.util.List;

public class FacturaEncabezadoDto {
	private String des_num_factura;
	
	private int id_cliente;
	
	private int id_tienda;
	
	private int id_empleado;
	
	List<FacturaCuerpoDto> listCuerpo;

	public FacturaEncabezadoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDes_num_factura() {
		return des_num_factura;
	}

	public void setDes_num_factura(String des_num_factura) {
		this.des_num_factura = des_num_factura;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public List<FacturaCuerpoDto> getListCuerpo() {
		return listCuerpo;
	}

	public void setListCuerpo(List<FacturaCuerpoDto> listCuerpo) {
		this.listCuerpo = listCuerpo;
	}
	
	
	
}

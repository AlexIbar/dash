package com.dashboard.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.dto.FacturaCuerpoDto;
import com.dashboard.back.dto.FacturaEncabezadoDto;
import com.dashboard.back.model.Venta_cuerpo;
import com.dashboard.back.model.Venta_encabezado;
import com.dashboard.back.repository.EmpleadoRepository;
import com.dashboard.back.repository.IClienteRepository;
import com.dashboard.back.repository.ITiendaRepository;
import com.dashboard.back.repository.IVentasCuerpo;
import com.dashboard.back.repository.IVentasEncabezado;
import com.dashboard.back.repository.ProductoRepository;

@Service
public class FacturaService {
	
	@Autowired
	IVentasEncabezado ventasEncabezadoRepository;
	
	@Autowired
	IVentasCuerpo ventasCuerpoRepository;
	
	@Autowired
	IClienteRepository clienteRepository;
	
	@Autowired
	ITiendaRepository tiendaRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Venta_encabezado> findAll(){
		return this.ventasEncabezadoRepository.findAll();
	}
	
	public Venta_encabezado findById(Integer id){
		return this.ventasEncabezadoRepository.findById(id).orElse(null);
	}
	
	public Venta_encabezado crearEncabezado(FacturaEncabezadoDto fact) {
		Venta_encabezado encabezado = new Venta_encabezado();
		var cliente =this.clienteRepository.findById(fact.getId_cliente()).orElse(null);
		if(cliente == null) {
			return null;
		}
		
		var tienda = this.tiendaRepository.findById(fact.getId_tienda()).orElse(null);
		if(tienda == null) {
			return null;
		}
		
		var empleado = this.empleadoRepository.findById(fact.getId_empleado()).orElse(null);
		
		if(empleado == null) {
			return null;
		}
		
		var existenProductos = this.validarProductos(fact.getListCuerpo());
		
		if(existenProductos == false) {
			return null;
		}
		
		encabezado.setCliente(cliente);
		encabezado.setEmpleado(empleado);
		encabezado.setTienda(tienda);
		encabezado.setDes_num_factura(fact.getDes_num_factura());
		encabezado.setValor_factura(this.calcularValorFactura(fact.getListCuerpo()));
		Venta_encabezado encabezadoResp = this.ventasEncabezadoRepository.save(encabezado);
		this.crearCuerpo(encabezadoResp, fact.getListCuerpo());
		return this.ventasEncabezadoRepository.findById(encabezadoResp.getId_factura()).orElse(null);
	}
	
	public boolean crearCuerpo(Venta_encabezado encabezado, List<FacturaCuerpoDto> dat) {
		for(int i =0; i<dat.size(); i++) {
			FacturaCuerpoDto cuerpo = dat.get(i);
			var producto = this.productoRepository.findById(dat.get(i).getId_producto()).orElse(null);
			var newCuerpo = new Venta_cuerpo();
			
			newCuerpo.setCantidad(cuerpo.getCantidad());
			newCuerpo.setProducto(producto);
			newCuerpo.setValor(cuerpo.getValor());
			newCuerpo.setVenta_encabezado(encabezado);
			
			var resp = this.ventasCuerpoRepository.save(newCuerpo);
			
			if(resp == null) {
				return false;
			}
			
		}
		return true;
	}
	
	public double calcularValorFactura(List<FacturaCuerpoDto> dat) {
		double valor = 0;
		for(int i =0; i<dat.size(); i++) {
			valor = valor +(dat.get(i).getValor()*dat.get(i).getCantidad());
		}
		return valor;
	}
	
	public boolean validarProductos(List<FacturaCuerpoDto> dat) {
		boolean estado = true;
		for(int i =0; i<dat.size(); i++) {
			var producto = this.productoRepository.findById(dat.get(i).getId_producto()).orElse(null);
			
			if(producto == null) {
				estado = false;
				break;
			}
		}
		return estado;
	}

}

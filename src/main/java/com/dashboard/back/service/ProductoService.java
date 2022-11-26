package com.dashboard.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.dto.ProductoDto;
import com.dashboard.back.dto.ProveedorDto;
import com.dashboard.back.model.Producto;
import com.dashboard.back.model.Proveedor;
import com.dashboard.back.repository.ProductoRepository;

public class ProductoService implements BaseService<ProductoDto> {
	
	@Autowired
	private ProductoRepository productRepository;
	
	@Autowired
	ProveedorService proveedorService;
	
	@Override
	public List<ProductoDto> findAll() {
		List<Producto> productoList = this.productRepository.findAll();
		
		if(productoList == null || productoList.size() == 0 ) {
			return null;
		}
		
		int numProductos = productoList.size();
		List<ProductoDto> listProductDto = new ArrayList<ProductoDto>();
		for(int i = 0; i < numProductos; i++) {
			var prodDto = this.generateProductoDto( productoList.get(i) );
			listProductDto.add(prodDto);
		}
		return null;
	}

	@Override
	public ProductoDto save(ProductoDto producto) {
		
		if(producto == null) {
			return null;
		}
		ProveedorDto proveedor = this.proveedorService.findId(producto.getProveedorId());
		
		if(proveedor == null) {
			return null;
		}
		Producto productoSave = new Producto();
		Proveedor prov = new Proveedor();
		
		prov.setId_proveedor(proveedor.getId_proveedor());
		prov.setNit_proveedor(proveedor.getNit_proveedor());
		prov.setNombre_proveedor(proveedor.getNombre_proveedor());
		prov.setProductos(proveedor.getProductos());
		
		productoSave.setActivo(producto.isActivo());
		productoSave.setCosto(producto.getCosto());
		productoSave.setProveedor(prov);
		productoSave.setNombre_producto(producto.getNombre_producto());
		productoSave.setValor_producto(producto.getValor_producto());
		
		Producto prod = this.productRepository.save(productoSave);
		
		if(prod == null) {
			return null;
		}
		
		return this.generateProductoDto(prod);
		// TODO Auto-generated method stub
	}

	@Override
	public ProductoDto findId(Integer id) {
		// TODO Auto-generated method stub
		Producto prod = this.productRepository.findById(id).orElse(null);
		
		if(prod == null) {
			return null;
		}
		
		ProductoDto producto = this.generateProductoDto(prod);
		
		return producto;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.productRepository.deleteById(id);
	}
	
	public ProductoDto generateProductoDto(Producto prod) {
		ProductoDto p =  new ProductoDto();
		p.setId_producto(prod.getId_producto());
		p.setValor_producto(prod.getValor_producto());
		p.setActivo(prod.isActivo());
		p.setCosto(prod.getCosto());
		p.setProveedor(prod.getProveedor());
		return p;
	}

	@Override
	public ProductoDto update(ProductoDto producto, Integer id) {
		// TODO Auto-generated method stub
		ProductoDto productoDto = this.findId(id);
		
		if(productoDto == null) {
			return null;
		}
		if(productoDto.getCosto() != producto.getCosto()) {
			productoDto.setCosto(producto.getCosto());
		}
		if(productoDto.getProveedorId() != producto.getProveedorId()) {
			productoDto.setProveedorId(producto.getProveedorId());
		}
		if(productoDto.getNombre_producto() != producto.getNombre_producto()) {
			productoDto.setNombre_producto(producto.getNombre_producto());
		}
		if(productoDto.getValor_producto() != producto.getValor_producto()) {
			productoDto.setValor_producto(producto.getValor_producto());
		}
		return this.save(productoDto);
	}

}

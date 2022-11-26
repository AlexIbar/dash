package com.dashboard.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.dto.ProveedorDto;
import com.dashboard.back.model.Proveedor;
import com.dashboard.back.repository.ProveedorRepository;

@Service
public class ProveedorService implements BaseService<ProveedorDto> {
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public List<ProveedorDto> findAll() {
		// TODO Auto-generated method stub
		List<Proveedor> proveedor = this.proveedorRepository.findAll();
		List<ProveedorDto> proveedorDtoList = new ArrayList<ProveedorDto>();
		if(proveedor == null || proveedor.size() == 0) {
			return proveedorDtoList;
		}
		int tamProveedores = proveedor.size();
		
		for(int i = 0; i< tamProveedores; i++) {
			ProveedorDto prov = proveedorDtoGenerate( proveedor.get(i) );
			proveedorDtoList.add(prov);
		}
		return proveedorDtoList;
	}

	@Override
	public ProveedorDto save(ProveedorDto proveedor) {
		// TODO Auto-generated method stub
		if(proveedor == null) {
			return null;
		}
		Proveedor prov = new Proveedor();
		prov.setNit_proveedor(proveedor.getNit_proveedor());
		prov.setNombre_proveedor(proveedor.getNombre_proveedor());
		prov.setProductos(proveedor.getProductos());
		
		var dataResponse = this.proveedorRepository.save(prov);
		
		ProveedorDto proveedorSave = this.proveedorDtoGenerate(dataResponse);
		return proveedorSave;
		
	}

	@Override
	public ProveedorDto findId(Integer id) {
		// TODO Auto-generated method stub
		Proveedor proveedor = this.proveedorRepository.findById(id).orElse(null);
		
		if (proveedor == null) {
			return null;
		}
		
		ProveedorDto proveedorDto = this.proveedorDtoGenerate(proveedor);
		return proveedorDto;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.proveedorRepository.deleteById(id);
	}
	
	private ProveedorDto proveedorDtoGenerate(Proveedor dataResponse) {
		ProveedorDto prov = new ProveedorDto(
				dataResponse.getId_proveedor(),
				dataResponse.getNit_proveedor(),
				dataResponse.getNombre_proveedor(),
				dataResponse.getProductos()
		);
		return prov;
	}

	@Override
	public ProveedorDto update(ProveedorDto proveedor, Integer id) {
		ProveedorDto proveedorDto = this.findId(id);
		
		if(proveedorDto == null) {
			return null;
		}
		
		if(proveedor.getNombre_proveedor() != proveedorDto.getNombre_proveedor()) {
			proveedorDto.setNombre_proveedor(proveedor.getNombre_proveedor());
		}
		if(proveedor.getNit_proveedor() != proveedorDto.getNit_proveedor()) {
			proveedorDto.setNit_proveedor(proveedor.getNit_proveedor());
		}
		return this.save(proveedorDto);
	}
	
	
}

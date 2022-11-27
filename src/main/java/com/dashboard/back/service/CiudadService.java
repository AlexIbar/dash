package com.dashboard.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.model.Ciudad;
import com.dashboard.back.repository.ICiudadRepository;

@Service
public class CiudadService implements BaseService<Ciudad>{

	@Autowired
	ICiudadRepository ciudadRepository;

	@Override
	public List<Ciudad> findAll() {
		return this.ciudadRepository.findAll();
	}

	@Override
	public Ciudad findId(Integer id) {
		Ciudad ciu = this.ciudadRepository.findById(id).orElse(null);
		if(ciu == null) {
			return null;
		}
		return ciu;
	}

	@Override
	public Ciudad save(Ciudad ciudad) {
		return this.ciudadRepository.save(ciudad);
	}

	@Override
	public Ciudad update(Ciudad ciudad, Integer id) {
		Ciudad ciu = this.findId(id);
		ciu.setNombre(ciudad.getNombre());
		return this.save(ciu);
	}

	@Override
	public void delete(Integer id) {}
	
	
}

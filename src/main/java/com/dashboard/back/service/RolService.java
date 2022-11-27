package com.dashboard.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.model.Rol;
import com.dashboard.back.repository.RolRepository;

@Service
public class RolService implements BaseService<Rol> {
	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<Rol> findAll() {
		return this.rolRepository.findAll();
	}

	@Override
	public Rol findId(Integer id) {
		var rol = this.rolRepository.findById(id).orElse(null);
		return rol;
	}

	@Override
	public Rol save(Rol rol) {
		return this.rolRepository.save(rol);
	}

	@Override
	public Rol update(Rol rol, Integer id) {
		var rolSearch = this.findId(id);
		
		if(rolSearch == null) {
			return null;
		}
		rolSearch.setNombre_rol(rol.getNombre_rol());
		rolSearch.setDes_rol(rol.getDes_rol());
		return this.save(rolSearch);
	}

	@Override
	public void delete(Integer id) {
		this.rolRepository.deleteById(id);
	}
	
}

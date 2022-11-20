package com.dashboard.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.model.Rol;
import com.dashboard.back.repository.RolRepository;

@Service
public class RolService {
	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> findAll(){
		return rolRepository.findAll();
	}
	public Rol save(Rol Rol) {
		return rolRepository.save(Rol);
	}
	public Optional<Rol> findId(Integer id) {
		return rolRepository.findById(id);
	}
	public void delete(Integer id) { 
		rolRepository.deleteById(id);
	}
}

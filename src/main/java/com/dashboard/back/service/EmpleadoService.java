package com.dashboard.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.model.Empleado;
import com.dashboard.back.repository.EmpleadoRepository;

@Service
public class EmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	public List<Empleado> findAll(){
		return empleadoRepository.findAll();
	}
	public Empleado save(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	public Optional<Empleado> findId(Integer id) {
		return empleadoRepository.findById(id);
	}
	public void delete(Integer id) { 
		empleadoRepository.deleteById(id);
	}
}

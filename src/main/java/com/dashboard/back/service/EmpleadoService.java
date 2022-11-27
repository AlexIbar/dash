package com.dashboard.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.dto.EmpleadoDto;
import com.dashboard.back.model.Empleado;
import com.dashboard.back.model.Rol;
import com.dashboard.back.repository.EmpleadoRepository;
import com.dashboard.back.repository.RolRepository;

@Service
public class EmpleadoService implements BaseService<EmpleadoDto>{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<EmpleadoDto> findAll() {
		// TODO Auto-generated method stub
		List<Empleado> empleados = empleadoRepository.findAll();
		List<EmpleadoDto> empleadosDto = new ArrayList<EmpleadoDto>();
		
		int numEmpleados = empleados.size();
		
		for(int i=0; i<numEmpleados; i++) {
			Empleado e = empleados.get(i);
			EmpleadoDto em = this.convertEntityDto(e);
			empleadosDto.add(em);
		}
		return empleadosDto;
		
	}

	@Override
	public EmpleadoDto findId(Integer id) {
		// TODO Auto-generated method stub
		var empleado = empleadoRepository.findById(id).orElse(null);
		return this.convertEntityDto(empleado);
	}

	@Override
	public EmpleadoDto save(EmpleadoDto e) {
		Empleado em = new Empleado();
			em.setId_empleado(e.getId_empleado());
			em.setActivo(e.isActivo());
			em.setCedula(e.getCedula());
			em.setEmail(e.getEmail());
			em.setNombre(e.getNombre());
			em.setToken_cambio(e.getToken_cambio());
			em.setPassword(e.getPassword());
			
			if(e.getId_rol() != null && e.getId_rol() > 0) {
				List<Rol> roles = new ArrayList<Rol>();
				Rol role = this.rolRepository.findById(e.getId_rol()).orElse(null);
				roles.add(role);
				em.setRoles(roles);
			}
		var newEmplea = this.empleadoRepository.save(em);
		return this.convertEntityDto(newEmplea);
	}

	@Override
	public EmpleadoDto update(EmpleadoDto empleado, Integer id) {
		Empleado emplea = this.empleadoRepository.findById(id).orElse(null);
		if(emplea == null) {
			return null;
		}
		emplea.setEmail(empleado.getEmail());
		emplea.setCedula(empleado.getCedula());
		emplea.setNombre(empleado.getNombre());
		
		var upEmpleado = this.empleadoRepository.save(emplea);
		return this.convertEntityDto(upEmpleado);
	}

	@Override
	public void delete(Integer id) {
		Empleado emplea = this.empleadoRepository.findById(id).orElse(null);
		if(emplea != null) {
			emplea.setActivo(false);
		}
		this.empleadoRepository.save(emplea);
	}

	private EmpleadoDto convertEntityDto(Empleado e) {
		EmpleadoDto em = new EmpleadoDto();
		
		if(e == null) {
			return null;
		}
		em.setId_empleado(e.getId_empleado());
		em.setActivo(e.isActivo());
		em.setCedula(e.getCedula());
		em.setEmail(e.getEmail());
		em.setRoles(e.getRoles());
		em.setNombre(e.getNombre());
		em.setToken_cambio(e.getToken_cambio());
		
		return em;
	}
	
	
}

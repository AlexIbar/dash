package com.dashboard.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.model.Empleado;
import com.dashboard.back.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping()
	public ResponseEntity<List<Empleado>> getAll(){
		return ResponseEntity.ok().body(this.empleadoService.findAll());
	}
}

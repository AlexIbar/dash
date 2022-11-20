package com.dashboard.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.model.Rol;
import com.dashboard.back.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping()
	public ResponseEntity<List<Rol>> getAll(){
		return ResponseEntity.ok().body(rolService.findAll());
	}
}

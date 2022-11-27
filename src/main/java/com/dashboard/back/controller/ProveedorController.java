package com.dashboard.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.dto.ProveedorDto;
import com.dashboard.back.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController{

	@Autowired
	ProveedorService proveedorService;
	
	@GetMapping()
	public ResponseEntity<List<ProveedorDto>> findAll() {
		return  new ResponseEntity<List<ProveedorDto>>(
				this.proveedorService.findAll(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/search")
	public ResponseEntity<ProveedorDto> findById(@RequestParam Integer id) {
		return new ResponseEntity<ProveedorDto>(
				this.proveedorService.findId(id), HttpStatus.ACCEPTED);
	}

	@PostMapping()
	public ResponseEntity<ProveedorDto> save(@RequestBody ProveedorDto datos) {
		return new ResponseEntity<ProveedorDto>(this.proveedorService.save(datos), HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<ProveedorDto> update(@RequestBody ProveedorDto datos, @RequestParam Integer id) {
		return new ResponseEntity<ProveedorDto>(this.proveedorService.update(datos, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
			this.proveedorService.delete(id);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

}

package com.dashboard.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.Base.IBaseController;
import com.dashboard.back.dto.EmpleadoDto;
import com.dashboard.back.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController implements IBaseController<EmpleadoDto> {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Override
	@GetMapping()
	public ResponseEntity<List<EmpleadoDto>> findAll(){
		return ResponseEntity.ok().body(this.empleadoService.findAll());
	}

	@Override
	@GetMapping("/search")
	public ResponseEntity<EmpleadoDto> findById(@RequestParam Integer id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok().body(this.empleadoService.findId(id));
	}

	@Override
	@PostMapping()
	public ResponseEntity<EmpleadoDto> save(EmpleadoDto datos) {
		// TODO Auto-generated method stub
		return new ResponseEntity<EmpleadoDto>(this.empleadoService.save(datos), HttpStatus.CREATED);
	}

	@Override
	@PutMapping()
	public ResponseEntity<EmpleadoDto> update(@RequestBody EmpleadoDto datos, @RequestParam Integer id) {
		return new ResponseEntity<EmpleadoDto>(this.empleadoService.update(datos, id), HttpStatus.CREATED);
	}

	@Override
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(@RequestParam Integer id) {
		// TODO Auto-generated method stub
		this.empleadoService.delete(id);
		return ResponseEntity.ok().body(true);
	}
}

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

import com.dashboard.back.Base.IBaseController;
import com.dashboard.back.model.Rol;
import com.dashboard.back.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController implements IBaseController<Rol> {
	
	@Autowired
	private RolService rolService;

	@Override
	@GetMapping()
	public ResponseEntity<List<Rol>> findAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok().body(this.rolService.findAll());
	}

	@Override
	@GetMapping("/search")
	public ResponseEntity<Rol> findById(@RequestParam Integer id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok().body(this.rolService.findId(id));
	}

	@Override
	@PostMapping()
	public ResponseEntity<Rol> save(@RequestBody Rol datos) {
		return new ResponseEntity<Rol>(this.rolService.save(datos), HttpStatus.CREATED);
	}

	@Override
	@PutMapping()
	public ResponseEntity<Rol> update(@RequestBody Rol datos,@RequestBody Integer id) {
		return new ResponseEntity<Rol>(this.rolService.update(datos, id), HttpStatus.ACCEPTED);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
		this.rolService.delete(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}
	
	
}

package com.dashboard.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.Base.IBaseController;
import com.dashboard.back.model.Ciudad;
import com.dashboard.back.service.CiudadService;


@RestController
@RequestMapping("/ciudad")
public class CiudadController implements IBaseController<Ciudad>{
	@Autowired
	CiudadService ciudadService;

	@Override
	@GetMapping()
	public ResponseEntity<List<Ciudad>> findAll() {
		return new ResponseEntity<List<Ciudad>>(this.ciudadService.findAll(), HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/search")
	public ResponseEntity<Ciudad> findById(@RequestParam Integer id) {
		return new ResponseEntity<Ciudad>(this.ciudadService.findId(id), HttpStatus.ACCEPTED);
	}

	@Override
	@PostMapping()
	public ResponseEntity<Ciudad> save(@RequestBody Ciudad datos) {
		return new ResponseEntity<Ciudad>(this.ciudadService.save(datos), HttpStatus.CREATED);
	}

	@Override
	@PutMapping()
	public ResponseEntity<Ciudad> update(@RequestBody Ciudad datos, @RequestParam Integer id) {
		return new ResponseEntity<Ciudad>(this.ciudadService.update(datos, id), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Boolean> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

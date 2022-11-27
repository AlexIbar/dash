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

import com.dashboard.back.dto.ClienteDto;
import com.dashboard.back.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController{
	
	@Autowired
	ClienteService clienteService;

	@GetMapping()
	public ResponseEntity<List<ClienteDto>> findAll() {
		return new ResponseEntity<List<ClienteDto>>(
				this.clienteService.findAll(),
				HttpStatus.ACCEPTED);
	}


	@GetMapping("/search")
	public ResponseEntity<ClienteDto> findById(@RequestParam String id) {
		// TODO Auto-generated method stub
		Integer id2 = Integer.parseInt(id);
		return new ResponseEntity<ClienteDto>(
				this.clienteService.findId(id2), HttpStatus.ACCEPTED);
	}


	@PostMapping()
	public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto datos) {
		// TODO Auto-generated method stub
		return new ResponseEntity<ClienteDto>(
				this.clienteService.save(datos),
				HttpStatus.CREATED);
	}


	@PutMapping()
	public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto datos, @RequestParam Integer id) {
		return new ResponseEntity<ClienteDto>(
				this.clienteService.update(datos, id),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
		this.clienteService.delete(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED );
	}

}

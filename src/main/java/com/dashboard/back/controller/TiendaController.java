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
import com.dashboard.back.dto.TiendaDto;
import com.dashboard.back.service.TiendaService;

@RestController
@RequestMapping("/tienda")
public class TiendaController implements IBaseController<TiendaDto> {
	
	@Autowired
	TiendaService tiendaService;

	@Override
	@GetMapping()
	public ResponseEntity<List<TiendaDto>> findAll() {
		return new ResponseEntity<List<TiendaDto>>(this.tiendaService.findAll(), HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/search")
	public ResponseEntity<TiendaDto> findById(@RequestParam Integer id) {
		return new ResponseEntity<TiendaDto>(this.tiendaService.findId(id), HttpStatus.ACCEPTED);
	}

	@Override
	@PostMapping()
	public ResponseEntity<TiendaDto> save(@RequestBody TiendaDto datos) {
		return new ResponseEntity<TiendaDto>(this.tiendaService.save(datos), HttpStatus.CREATED);
	}

	@Override
	@PutMapping()
	public ResponseEntity<TiendaDto> update(@RequestBody TiendaDto datos, @RequestParam Integer id) {
		return new ResponseEntity<TiendaDto>(this.tiendaService.update(datos, id), HttpStatus.ACCEPTED);
	}

	@Override
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(Integer id) {
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

}

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.dto.ProductoDto;
import com.dashboard.back.service.ProductoService;


@RestController
@RequestMapping("/producto")
public class ProductoController{

	@Autowired
	ProductoService productoService;

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<ProductoDto>> findAll() {
		List<ProductoDto> prod = this.productoService.findAll();
		return ResponseEntity.ok().body(prod);
		//return new ResponseEntity<List<ProductoDto>>(prod, HttpStatus.ACCEPTED);
	}

	@GetMapping("/search")
	public ResponseEntity<ProductoDto> findById(@RequestParam Integer id) {
		return new ResponseEntity<ProductoDto>(
				this.productoService.findId(id), HttpStatus.ACCEPTED
				);
	}

	@PostMapping()
	public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto datos) {
		return new ResponseEntity<ProductoDto>(this.productoService.save(datos), HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto datos, @RequestParam Integer id) {
		return new ResponseEntity<ProductoDto>(
				this.productoService.update(datos, id), HttpStatus.ACCEPTED
				);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
		this.productoService.delete(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

}

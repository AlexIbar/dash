package com.dashboard.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.back.dto.FacturaEncabezadoDto;
import com.dashboard.back.model.Venta_encabezado;
import com.dashboard.back.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	
	@Autowired
	FacturaService facturaService;
	
	@GetMapping()
	public ResponseEntity<List<Venta_encabezado>> findAll(){
		return new ResponseEntity<List<Venta_encabezado>>(this.facturaService.findAll(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/search")
	public ResponseEntity<Venta_encabezado> findById(@RequestParam Integer id){
		return new ResponseEntity<Venta_encabezado>(this.facturaService.findById(id), HttpStatus.ACCEPTED);
	}
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Venta_encabezado> crear(@RequestBody FacturaEncabezadoDto acturaEncabezado) {
		return new ResponseEntity<Venta_encabezado>(this.facturaService.crearEncabezado(acturaEncabezado), HttpStatus.CREATED);
	}
}

package com.dashboard.back.Base;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBaseController <E> {
	@GetMapping()
	public ResponseEntity<List<E>> findAll();
	
	@GetMapping()
	public ResponseEntity<E> findById(@RequestParam Integer id);
	
	@PostMapping()
	public ResponseEntity<E> save(@RequestBody E datos);
	
	@PutMapping()
	public ResponseEntity<E> update(@RequestBody E datos, @RequestParam Integer id);
	
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(@RequestParam Integer id);
}

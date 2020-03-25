package com.laboratorio.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.laboratorio.demo.services.IservicioGenerico;

public class ControllerGenerico <E, S extends IservicioGenerico<E>>{
	@Autowired	
	protected S service;

	

	@GetMapping("/")

	@Transactional
	
	
	public ResponseEntity<?> getAll(){
		
		try {
			System.out.println("entre al controler");
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body
					("{\"Mi mensaje get todos\": \""+e.getMessage()+"\"}");
			
		}
		
		
	}
	
	

	
	@GetMapping("/{id}")

	@Transactional
	public ResponseEntity<?>  getOne(@PathVariable int id) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body
					("{\"Mi mensaje get uno\": \""+e.getMessage()+"\"}");
			
		}
		

		
	}	
	
	@PostMapping("/")

	@Transactional
	public ResponseEntity<?> post(@RequestBody E personaForm) {
		
		try {
		

			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personaForm));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("{\"Mi mensaje post\": \""+e.getMessage()+"\"}");
						
		}
		
	}
	
	@PutMapping("/{id}")

	@Transactional
	public ResponseEntity<?> put(@PathVariable int id, @RequestBody E personaForm) {
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, personaForm));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("{\"Mi mensaje put\": \""+e.getMessage()+"\"}");
		}
		
	}
}

package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.services.OrderlineService;




	@RestController
	@RequestMapping("/orderlines")
	public class OrderlinesController {

		@Autowired
		public OrderlineService orderlineService;
		
		@GetMapping("/{id}")
		public ResponseEntity<Orderlines> findById(@PathVariable Integer id){
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(orderlineService.findById(id),headers , HttpStatus.OK);
	  }
		@GetMapping
		public ResponseEntity<List<Orderlines>> findAll() throws Exception {
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(orderlineService.findAll(), headers, HttpStatus.OK);
			}

		@PostMapping
		public Orderlines save(@RequestBody Orderlines orderlines) {
			return orderlineService.save(orderlines);
		}
		@PutMapping
	    public Orderlines update(Orderlines orderlines, Integer id){
	       return orderlineService.update(orderlines, id);
	    }
		
		@DeleteMapping
		public ResponseEntity<Orderlines> delete(@PathVariable Integer id) {
			HttpHeaders headers = new HttpHeaders();
			boolean isRemoved = orderlineService.delete(id);
			if (isRemoved) {
				return new ResponseEntity<>(headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
			}
			
		}
	}



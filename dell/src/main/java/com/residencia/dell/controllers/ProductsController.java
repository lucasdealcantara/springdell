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

import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	public ProductService productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productService.findById(id), headers, HttpStatus.OK);
  }
	@GetMapping
	public ResponseEntity<List<Products>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productService.findAll(),headers, HttpStatus.OK);
		}

	@PostMapping
	public Products save(@RequestBody Products products) {
		return productService.save(products);
	}
	@PutMapping
    public Products update(Products products, Integer id){
       return productService.update(products, id);
    }
	
	@DeleteMapping
	public ResponseEntity<Products> delete(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		boolean isRemoved = productService.delete(id);
		if (isRemoved) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		
	}
}





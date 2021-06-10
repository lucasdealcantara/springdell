package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;

@Service
public class ProductService {

	@Autowired
	public ProductsRepository productsRepository;

	public Products findById(Integer id) {
		return productsRepository.findById(id).get();
	}

	public List<Products> findAll() {
		return productsRepository.findAll();
	}

	public Long count() {
		return productsRepository.count();
	}

	public Products save(Products products) {
		Products novoProduct = productsRepository.save(products);
		return novoProduct;
	}

	public Products update(Products products, Integer id) {
		products.setProdId(id);
		return productsRepository.save(products);

	}
	public boolean delete(Integer id) {
		if (id != null) {
			productsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}

/*
 * METODO VO 
 * Public Products update(Integer id, Products novoProduct) { Products
 * antigoProduct = productsRepository.findById(id).get();
 * updateDados(antigoProduct, novoProduct); return
 * productsRepository.save(antigoProduct);}
 *
 */

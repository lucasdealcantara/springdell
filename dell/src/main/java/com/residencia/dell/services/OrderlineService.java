package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.repositories.OrderlinesRepository;

@Service
public class OrderlineService {
	@Autowired
	public OrderlinesRepository orderlinesRepository;

	public Orderlines findById(Integer id) {
		return orderlinesRepository.findById(id).get();
	}

	public List<Orderlines> findAll() {
		return orderlinesRepository.findAll();
	}

	public Long count() {
		return orderlinesRepository.count();
	}

	public Orderlines save(Orderlines orderlines) {
		Orderlines novoProduct = orderlinesRepository.save(orderlines);
		return novoProduct;
	}

	public Orderlines update(Orderlines orderlines, Integer id) {

		return orderlinesRepository.save(orderlines);

	}

	public boolean delete(Integer id) {
		if (id != null) {
			orderlinesRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}

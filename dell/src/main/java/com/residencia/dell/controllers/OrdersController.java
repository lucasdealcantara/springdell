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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.EmailService;
import com.residencia.dell.services.OrderService;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrdersVO;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/{id}")
	public ResponseEntity<Orders> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
	
		return new ResponseEntity<>(orderService.findById(id), headers, HttpStatus.OK);
	}
	
	
	@GetMapping("/notafiscal/{id}")
	public ResponseEntity<NotaFiscalVO> emitirNF(@PathVariable Integer id) throws Exception {
	HttpHeaders headers = new HttpHeaders();
	emailService.emailNotaFiscal(orderService.emitirNF(id));
	return new ResponseEntity<>(orderService.emitirNF(id), headers, HttpStatus.OK);
		}
		
	

	
	@GetMapping
	public ResponseEntity<List<Orders>> findAll(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.findAll(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<OrdersVO>> findAllVO(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.findAllVO(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return orderService.count();
	}

	/*@PostMapping
	public ResponseEntity<Orders> save(@RequestBody Orders order) {
		HttpHeaders headers = new HttpHeaders();
		Orders orders = orderService.save(order);
		if (null != orders)
			return ResponseEntity.ok().body(orders);
		else
			return new ResponseEntity<>(orderService.save(orders), headers, HttpStatus.BAD_REQUEST);
	}*/
	
	@PostMapping
    public ResponseEntity<OrdersVO> save(@RequestBody OrdersVO ordersVO){
        HttpHeaders headers = new HttpHeaders();
        OrdersVO novoOrdersVO = orderService.save(ordersVO);

        if(null != novoOrdersVO)
            return new ResponseEntity<>(novoOrdersVO, headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(novoOrdersVO, headers, HttpStatus.BAD_REQUEST);
    }

	@PutMapping("/{id}")
	public ResponseEntity<Orders> update(@PathVariable Integer id, @RequestBody Orders orders) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.update(id, orders), headers, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Orders> delete(@PathVariable Integer id) {
		try {
			orderService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
} 

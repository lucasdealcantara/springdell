package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ItemOrderLinesVO;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrderService {
	
	@Autowired
	public OrdersRepository ordersRepository;
	
	@Autowired
	public ProductsRepository productsRepository;
	
	@Autowired
	public OrderlinesRepository orderlinesRepository;

	public Orders findById(Integer id) {
		// return alunosRepository.getById(id).getNome();
		return ordersRepository.findById(id).get();
	}

	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	public List<Orders> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

				return listOrdersComPaginacao;
			} else {
				listOrders = ordersRepository.findAll();

				return listOrders;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}
	}
	
	
	public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;
		List<OrdersVO> listOrdersVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

				for (Orders lOrders : listOrdersComPaginacao) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			} else {
				listOrders = ordersRepository.findAll();

				for (Orders lOrders : listOrders) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listOrdersVO;
	}

	private OrdersVO convertEntidadeParaVO(Orders orders) {
		OrdersVO ordersVO = new OrdersVO();
		List<OrderLinesVO> listOrderLinesVO = new ArrayList<>();

		ordersVO.setNetAmount(orders.getNetAmount());
		ordersVO.setOrderDate(orders.getOrderdate());
		ordersVO.setOrderId(orders.getOrderid());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());

		for (Orderlines lOrderLines : orders.getListOrderlines()) {
			OrderLinesVO orderLinesVO = new OrderLinesVO();

			orderLinesVO.setOrderDate(lOrderLines.getOrderdate());
			orderLinesVO.setOrderLineId(lOrderLines.getOrderlineid());
			orderLinesVO.setProdId(lOrderLines.getProducts().getProdId());
			orderLinesVO.setQuantity(lOrderLines.getQuantity());

			listOrderLinesVO.add(orderLinesVO);
		}

		ordersVO.setListOrderLinesVO(listOrderLinesVO);

		return ordersVO;
	}

	public Long count() {
		return ordersRepository.count();
	}

	/*public Orders save(Orders orders) {
		Orders newOrders = ordersRepository.save(orders);
		return newOrders;
	}*/
	
	public OrdersVO save(OrdersVO ordersVO) {
        Orders novoOrders = converteVOParaEntidade(ordersVO, null);
        ordersRepository.save(novoOrders);
        return convertEntidadeParaVO(novoOrders);
    }
	
	private Orders converteVOParaEntidade(OrdersVO ordersVO, Integer id) {
        Orders orders = new Orders();
        List<Orderlines> listOrderlines = new ArrayList<>();

        orders.setNetAmount(ordersVO.getNetAmount());
        orders.setOrderdate(ordersVO.getOrderDate());
        orders.setOrderid(ordersVO.getOrderId());
        orders.setTax(ordersVO.getTax());
        orders.setTotalAmount(ordersVO.getTotalAmount());
//        orders.setListaOrderlines(ordersVO.getListOrderlinesVO());
        if(ordersVO.getListOrderLinesVO() != null) {
        for (OrderLinesVO orderlinesVO : ordersVO.getListOrderLinesVO()) {
            Orderlines orderlines = new Orderlines();
            orderlines.setOrderdate(orderlinesVO.getOrderDate());
            orderlines.setOrderlineid(orderlinesVO.getOrderLineId());
            orderlines.setQuantity(orderlinesVO.getQuantity());
            orderlines.setProducts(productsRepository.getById(orderlinesVO.getProdId()));
            orderlines.setOrders(orders);

            listOrderlines.add(orderlines);
        }
    }
        orders.setListOrderlines(listOrderlines);

        return orders;
    }
    

	public void delete(Integer id) {
		ordersRepository.deleteById(id);
	}

	public Orders update(Integer id, Orders orders) {
		Orders newOrders = ordersRepository.findById(id).get();
		updateDados(newOrders, orders);
		return ordersRepository.save(newOrders);
	}

	private void updateDados(Orders newOrders, Orders orders) {
		newOrders.setOrderdate(orders.getOrderdate());
		newOrders.setCustomers(orders.getCustomers());
		newOrders.setNetAmount(orders.getNetAmount());
		newOrders.setTax(orders.getTax());
		newOrders.setTotalAmount(orders.getTotalAmount());
	}
	
	public NotaFiscalVO emitirNF (Integer orderId) {
		Orders orders = ordersRepository.getById(orderId);
		List<Orderlines> listOrderlines = orders.getListOrderlines();		
		
		NotaFiscalVO NotaFiscalVO = new NotaFiscalVO();
		
		NotaFiscalVO.setFirstName(orders.getCustomers().getFirstName());
		NotaFiscalVO.setCustomerLastName(orders.getCustomers().getLastName());
		NotaFiscalVO.setNetAmount(orders.getNetAmount());
		NotaFiscalVO.setOrderDate(orders.getOrderdate());
		NotaFiscalVO.setOrderId(orders.getOrderid());
		NotaFiscalVO.setTotalAmount(orders.getTotalAmount());
		
		List<ItemOrderLinesVO> listItemOrderLinesVO = new ArrayList<>();
		for(Orderlines orderlines: listOrderlines) {
			//notafiscalVO.setListItemOrderLinesVO(null);
			ItemOrderLinesVO itemOrderLinesVO = new ItemOrderLinesVO();
			itemOrderLinesVO.setProdId(orderlines.getProducts().getProdId());
			itemOrderLinesVO.setQuantity(orderlines.getQuantity());
			itemOrderLinesVO.setProdTitle(orderlines.getProducts().getTitle());
			listItemOrderLinesVO.add(itemOrderLinesVO);	
		}
		
		NotaFiscalVO.setListItemOrderLinesVO(listItemOrderLinesVO);
		return NotaFiscalVO;
	}

}
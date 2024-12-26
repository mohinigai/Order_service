package com.task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.task.Dto.Product;
import com.task.model.Order;
import com.task.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderServiceI {
	@Autowired
	private OrderRepository orderepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Order createOrder(Order order) {
		Order createorder = orderepository.save(order);
		return createorder;
	}

	@Override
	public Order updateOrder(Order order, Long ordid) {
		Order byid = orderepository.findById(ordid)
				.orElseThrow(() -> new RuntimeException("Order Id not found" + ordid));
		byid.setAddress(order.getAddress());
		byid.setQuntity(order.getQuntity());
		byid.setTotalAmount(order.getTotalAmount());
		byid.setIsDeliver(order.getIsDeliver());
		Order updatedOrd = orderepository.save(byid);
		return updatedOrd;
	}

	@Override
	public Order getSingleOrder(Long ordid) {
		Order ordbyId = orderepository.findById(ordid)
				.orElseThrow(() -> new RuntimeException("Order id not found" + ordid));
		return ordbyId;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> collect = orderepository.findAll().stream().map(c -> c).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<Order> getAllOrdersCutomerById(Long custId) {
		List<Order> list = orderepository.findByCustomerId(custId);
		List<Order> orderlist = new ArrayList<>();
		for (Order l : list) {
			if (l.getOrdid() != null) {
				String url = "http://localhost:9092/api/products/order/" + l.getOrdid();
				Product[] product = restTemplate.getForObject(url, Product[].class);
				List<Product> productlist = Arrays.asList(product);
				l.setProductList(productlist);
				orderlist.add(l);
			}
         
		}

		return orderlist;

	}
}

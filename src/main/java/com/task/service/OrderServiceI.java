package com.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.model.Order;

@Service
public interface OrderServiceI {
	
	public Order createOrder(Order order);
	
	public Order updateOrder(Order order, Long ordid);
	
	public Order getSingleOrder( Long ordid);
	
	public List<Order> getAllOrder();
	
	public List<Order>getAllOrdersCutomerById(Long custId);
	
	

}

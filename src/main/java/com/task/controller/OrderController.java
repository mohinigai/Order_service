package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Order;
import com.task.service.OrderServiceI;
@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private OrderServiceI orderServiceI;
	@PostMapping("/orders")
	public ResponseEntity<Order> creatOrder(@RequestBody Order order){
		Order saveord = orderServiceI.createOrder(order);
		return new ResponseEntity<Order>(saveord,HttpStatus.CREATED);	
	}
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable ("id")Long ordid){
		 Order updateOrder = orderServiceI.updateOrder(order, ordid);
		return new ResponseEntity<Order>(updateOrder,HttpStatus.CREATED);	
	}
	@GetMapping("/orders")
	public ResponseEntity<List<Order>>getAllOrder(){
		 List<Order> allOrder = orderServiceI.getAllOrder();
		return new ResponseEntity<List<Order>>(allOrder,HttpStatus.OK);	
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order>getSingleOrder(@PathVariable ("id")Long ordid){
		  Order singleOrder = orderServiceI.getSingleOrder(ordid);
		return new ResponseEntity<Order>(singleOrder,HttpStatus.OK);	
   }
	@GetMapping("/orders/customer/{id}")
	public ResponseEntity<List<Order>>getAllOrdersByCustomerId(@PathVariable ("id") Long custId){
		List<Order> allOrdersCutomerById = orderServiceI.getAllOrdersCutomerById(custId);
		return new ResponseEntity<List<Order>>(allOrdersCutomerById,HttpStatus.OK);	
	}

}




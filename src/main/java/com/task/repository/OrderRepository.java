package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	//@Query(value = "SELECT * FROM Orders_dtl WHERE customer_id = :custId", nativeQuery = true)
	//List<Order> findByCustomerId(@Param("custId") Long custId);
	List<Order> findByCustomerId(Long custId);
	
	
	
}


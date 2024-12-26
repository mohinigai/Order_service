package com.task.model;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.task.Dto.Product;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders_dtl")
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORD_ID")
	private Long ordid;
    
    @Column(name="CUSTOMER_ID")
	private Long customerId;
    
    @Column(name="PRODUCT_ID")
	private Long pid;
    
    @Column(name="CART_ID")
	private Long cartId;
    
    @Column(name="TOTAL_AMOUNT")
    private Double totalAmount;
    
    @Column(name="ORD_QUANTITY")
	private Integer quntity;
    
    @Column(name="ADDRESS")
	private String address;
    
    @Column(name="PAYMENT_MODE")
	private String paymentMode;
    
    @Column(name="IS_DELIVER")
	private String isDeliver;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
	@javax.persistence.Transient
	private List<Product> productList;

}

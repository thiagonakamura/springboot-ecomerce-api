package com.example.springboot_ecomerce_api.entities;

import java.io.Serializable;
import java.util.Objects;

import com.example.springboot_ecomerce_api.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents an order item entity in the e-commerce system.
 * This entity links an order and a product, specifying the quantity and price for that product in a given order.
 * It is mapped to the "tb_order_item" table in the database.
 */

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId // Defines a composite primary key using OrderItemPK
	private OrderItemPK id = new OrderItemPK();//primary key based on order and product
	private Integer quantity;
	private Double price;
	
	public OrderItemEntity() {
		
	}

	public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public OrderEntity getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(OrderEntity order) {
		id.setOrder(order);
	}
	
	public ProductEntity getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(ProductEntity product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}
	

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//method to calculate the subtotal for an order item.
	public Double getSubTotal() {
		return price * quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemEntity other = (OrderItemEntity) obj;
		return Objects.equals(id, other.id);
	}
}

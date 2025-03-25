package com.example.springboot_ecomerce_api.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.example.springboot_ecomerce_api.entities.OrderEntity;
import com.example.springboot_ecomerce_api.entities.ProductEntity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Composite primary key class for OrderItem.
 * This class represents the primary key for the OrderItem entity,
 * which is composed of both an Order and a Product.
 */

//Marks this class as a composite primary key
@Embeddable
public class OrderItemPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")// Foreign key reference to the Order table
	private OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")// Foreign key reference to the Product table
	private ProductEntity product;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
}

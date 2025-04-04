package com.example.springboot_ecomerce_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.springboot_ecomerce_api.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents a order entity in the e-commerce system.
 * This class is mapped to the "tb_order" table in the database.
 */

@Entity
@Table(name = "tb_order")
public class OrderEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-incremented primary key
	private Long id;
	private Instant moment;
	
	private OrderStatus status;
	
	// Many-to-one relationship: Each order is associated with one user (client).
	// The foreign key "user_id" links this order to a specific user.
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItemEntity> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private PaymentEntity payment;
	
	public OrderEntity() {
		
	}

	public OrderEntity(Long id, Instant moment, OrderStatus status, UserEntity client) {
		super();
		this.id = id;
		this.moment = moment;
		setStatus(status);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public UserEntity getClient() {
		return client;
	}

	public void setClient(UserEntity client) {
		this.client = client;
	}
	
	public Set<OrderItemEntity> getItems() {
		return items;
	}
	
	//method to calcluate the total for an order.
	//the total is the sum of all the subtotals from the order items.
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItemEntity x : items) {
			sum += x.getSubTotal();
		}
		return sum;
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
		OrderEntity other = (OrderEntity) obj;
		return Objects.equals(id, other.id);
	}
}

package com.example.springboot_ecomerce_api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a user entity in the e-commerce system.
 * This class is mapped to the "tb_user" table in the database.
 */

@Entity
@Table(name = "tb_user")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-incremented primary key
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore
	// One-to-many relationship: A user can have multiple orders.
	// The "client" field in the OrderEntity class establishes the relationship.
	@OneToMany(mappedBy = "client")
	private List<OrderEntity> orders = new ArrayList<>();
	
	//Default constructor required by JPA.
	public UserEntity() {
		
	}

	//Parameterized constructor to initialize a UserEntity instance.
	public UserEntity(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	// Getters and setters for each attribute
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}
	
	//Ensures entity equality is based on the unique identifier (ID).
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
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id);
	}
}

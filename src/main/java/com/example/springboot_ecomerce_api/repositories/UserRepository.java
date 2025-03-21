package com.example.springboot_ecomerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_ecomerce_api.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}

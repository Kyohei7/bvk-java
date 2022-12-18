package com.bvk.bvkjavaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvk.bvkjavaspringboot.model.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}

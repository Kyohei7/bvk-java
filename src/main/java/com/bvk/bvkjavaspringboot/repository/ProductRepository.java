package com.bvk.bvkjavaspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bvk.bvkjavaspringboot.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Get Data Product Where product name LIKE
    @Query(value = "SELECT * FROM products WHERE name = ?1 AND status = true", nativeQuery = true)
    List<Product> searchProductByName(String name);

}

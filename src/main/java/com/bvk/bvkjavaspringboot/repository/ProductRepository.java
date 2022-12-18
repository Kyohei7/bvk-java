package com.bvk.bvkjavaspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bvk.bvkjavaspringboot.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE name like concat('%', ?1, '%') AND status = true", nativeQuery = true)
    List<Product> searchProductByName(String name);

}

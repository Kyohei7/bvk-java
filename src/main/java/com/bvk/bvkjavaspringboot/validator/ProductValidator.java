package com.bvk.bvkjavaspringboot.validator;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bvk.bvkjavaspringboot.exception.custom.NotFoundException;
import com.bvk.bvkjavaspringboot.model.entity.Product;

@Service
public class ProductValidator {

    public void validateProductNotFound(List<Product> product) throws Exception {
        if (product.isEmpty()) {
            throw new NotFoundException("Product is not found!");
        }
    }

    public void validateProductIsNotExisting(Optional<Product> productFind) throws Exception {
        if (!productFind.isPresent()) {
            throw new NotFoundException("Product Not Found");
        }
    }

}

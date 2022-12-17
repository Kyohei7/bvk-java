package com.bvk.bvkjavaspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;
import com.bvk.bvkjavaspringboot.model.entity.Product;
import com.bvk.bvkjavaspringboot.repository.ProductRepository;
import com.bvk.bvkjavaspringboot.validator.ProductValidator;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductValidator productValidator;

    private ResponseData responseData;

    @Override
    public ResponseData searchProductService(String name) throws Exception {

        List<Product> products = productRepository.searchProductByName(name);

        productValidator.validateProductNotFound(products);

        responseData = new ResponseData(200, "Get Data Product Success", products);

        return responseData;

    }

}

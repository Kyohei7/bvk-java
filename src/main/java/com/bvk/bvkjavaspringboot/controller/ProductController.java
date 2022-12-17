package com.bvk.bvkjavaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;
import com.bvk.bvkjavaspringboot.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    private ResponseData responseData;

    @GetMapping
    public ResponseEntity<ResponseData> searchProduct(@RequestParam(value = "name", defaultValue = "") String name)
            throws Exception {
        responseData = productService.searchProductService(name);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

}

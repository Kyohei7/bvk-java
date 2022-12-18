package com.bvk.bvkjavaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvk.bvkjavaspringboot.model.dto.request.CartRequest;
import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;
import com.bvk.bvkjavaspringboot.service.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    private ResponseData responseData;

    @PostMapping
    public ResponseEntity<ResponseData> addToCart(@RequestBody @Valid CartRequest request) throws Exception {
        responseData = cartService.addToCartService(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{idCart}")
    public ResponseEntity<ResponseData> removeToCart(@PathVariable Long idCart) throws Exception {
        responseData = cartService.removeToCartService(idCart);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

}

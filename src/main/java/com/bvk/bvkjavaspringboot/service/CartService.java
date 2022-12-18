package com.bvk.bvkjavaspringboot.service;

import com.bvk.bvkjavaspringboot.model.dto.request.CartRequest;
import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;

public interface CartService {

    ResponseData addToCartService(CartRequest request) throws Exception;

}

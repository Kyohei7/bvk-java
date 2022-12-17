package com.bvk.bvkjavaspringboot.service;

import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;

public interface ProductService {

    ResponseData searchProductService(String name) throws Exception;

}

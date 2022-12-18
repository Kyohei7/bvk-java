package com.bvk.bvkjavaspringboot.service;

import com.bvk.bvkjavaspringboot.model.dto.request.TransactionRequest;
import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;

public interface TransactionService {

    ResponseData finalizeDataCartService(TransactionRequest request) throws Exception;

}

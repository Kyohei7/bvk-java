package com.bvk.bvkjavaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvk.bvkjavaspringboot.model.dto.request.TransactionRequest;
import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;
import com.bvk.bvkjavaspringboot.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private ResponseData responseData;

    @PostMapping
    public ResponseEntity<ResponseData> finalizeDataCart(@RequestBody @Valid TransactionRequest request)
            throws Exception {
        responseData = transactionService.finalizeDataCartService(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

}

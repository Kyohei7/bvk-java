package com.bvk.bvkjavaspringboot.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvk.bvkjavaspringboot.model.dto.request.TransactionRequest;
import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;
import com.bvk.bvkjavaspringboot.model.entity.Cart;
import com.bvk.bvkjavaspringboot.model.entity.Transaction;
import com.bvk.bvkjavaspringboot.repository.CartRepository;
import com.bvk.bvkjavaspringboot.repository.TransactionRepository;
import com.bvk.bvkjavaspringboot.validator.CartValidator;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartValidator cartValidator;

    private ResponseData responseData;

    @Override
    public ResponseData finalizeDataCartService(TransactionRequest request) throws Exception {

        Optional<Cart> cartFind = cartRepository.findById(request.getCart_id());

        cartValidator.validateCartIsNotExisting(cartFind);

        Cart cart = cartFind.get();

        Transaction transaction = new Transaction(
                cart.getPrice() * cart.getQuantity(),
                LocalDateTime.now());
        transaction.setUser(cart.getUser());
        transaction.setCart(cart);

        transactionRepository.save(transaction);

        responseData = new ResponseData(200, "Success Calculate Data Cart", transaction);

        return responseData;
    }

}

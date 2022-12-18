package com.bvk.bvkjavaspringboot.validator;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bvk.bvkjavaspringboot.exception.custom.NotFoundException;
import com.bvk.bvkjavaspringboot.exception.custom.NotProcessException;
import com.bvk.bvkjavaspringboot.model.entity.Cart;

@Service
public class CartValidator {
    public void validateCartIsNotExisting(Optional<Cart> cartFind) throws Exception {
        if (!cartFind.isPresent()) {
            throw new NotFoundException("Data Cart Not Found");
        }
    }

    public void validateIsAlreadyRemove(Cart cart) throws Exception {
        if (Objects.nonNull(cart.getStatus()) && cart.getStatus()) {
            throw new NotProcessException("Cart is already remove!");
        }
    }
}

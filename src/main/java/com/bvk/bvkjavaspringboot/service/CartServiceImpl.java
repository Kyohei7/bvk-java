package com.bvk.bvkjavaspringboot.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvk.bvkjavaspringboot.model.dto.request.CartRequest;
import com.bvk.bvkjavaspringboot.model.dto.response.ResponseData;
import com.bvk.bvkjavaspringboot.model.entity.Cart;
import com.bvk.bvkjavaspringboot.model.entity.Product;
import com.bvk.bvkjavaspringboot.model.entity.User;
import com.bvk.bvkjavaspringboot.repository.CartRepository;
import com.bvk.bvkjavaspringboot.repository.ProductRepository;
import com.bvk.bvkjavaspringboot.repository.UserRepository;
import com.bvk.bvkjavaspringboot.validator.CartValidator;
import com.bvk.bvkjavaspringboot.validator.ProductValidator;
import com.bvk.bvkjavaspringboot.validator.UserValidator;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CartValidator cartValidator;

    private ResponseData responseData;

    @Override
    public ResponseData addToCartService(CartRequest request) throws Exception {

        // Validate user id and product id
        Optional<User> userFind = userRepository.findById(request.getUser_id());
        Optional<Product> productFind = productRepository.findById(request.getProduct_id());

        productValidator.validateProductIsNotExisting(productFind);
        userValidator.validateUserNotFound(userFind);

        Product product = productFind.get();
        User user = userFind.get();

        Cart cart = new Cart(request.getQuantity(), product.getPrice());
        cart.setUser(user);
        cart.setProduct(product);

        cartRepository.save(cart);

        responseData = new ResponseData(201, "Success Add to Cart", cart);

        return responseData;
    }

    @Override
    public ResponseData removeToCartService(long idCart) throws Exception {

        Optional<Cart> cartFind = cartRepository.findById(idCart);

        cartValidator.validateCartIsNotExisting(cartFind);

        Cart cart = cartFind.get();

        cartValidator.validateIsAlreadyRemove(cart);

        cart.setStatus(true);

        responseData = new ResponseData(200, "Success Remove Cart", null);

        return responseData;
    }

}

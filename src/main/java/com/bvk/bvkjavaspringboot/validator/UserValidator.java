package com.bvk.bvkjavaspringboot.validator;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bvk.bvkjavaspringboot.exception.custom.NotFoundException;
import com.bvk.bvkjavaspringboot.model.entity.User;

@Service
public class UserValidator {
    public void validateUserNotFound(Optional<User> userFind) throws Exception {
        if (userFind.isEmpty()) {
            throw new NotFoundException("User is not found! Please register!");
        }
    }
}

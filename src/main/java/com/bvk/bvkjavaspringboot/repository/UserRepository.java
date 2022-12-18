package com.bvk.bvkjavaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvk.bvkjavaspringboot.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

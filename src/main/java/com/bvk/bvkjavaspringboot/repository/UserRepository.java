package com.bvk.bvkjavaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bvk.bvkjavaspringboot.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

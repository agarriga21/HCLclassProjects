package com.hcl.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hcl.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);
}
package com.hcl.Phase3End.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hcl.Phase3End.entities.User;



public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);
}
package com.project.UserManager.repositories;
import org.springframework.data.repository.CrudRepository;

import com.project.UserManager.entities.User;
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);
}

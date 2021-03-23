package com.hcl.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entities.User;
import com.hcl.exceptions.UserNotFoundException;
import com.hcl.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	 public Iterable<User> GetAllUsers()
	    {
	        return userRepository.findAll();
	    }

    public User GetUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        if (foundUser==null) {
    		throw new UserNotFoundException();
    	}
        return foundUser;
    }
public boolean ValidPassword(String password, User user) {
	
	if(user.getPassword().equals(password)) {
		return true;
	}
	else {
		return false;
	}
}

}
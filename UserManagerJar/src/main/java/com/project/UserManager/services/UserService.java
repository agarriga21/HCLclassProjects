package com.project.UserManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.UserManager.entities.User;
import com.project.UserManager.exceptions.UserNotFoundException;
import com.project.UserManager.repositories.UserRepository;



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
        return foundUser;
    }
    
    public User GetUserById(int id) throws UserNotFoundException {
    	
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	
    
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }


}
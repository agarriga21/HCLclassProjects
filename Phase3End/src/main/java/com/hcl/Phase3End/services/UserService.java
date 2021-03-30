package com.hcl.Phase3End.services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.Phase3End.entities.User;
import com.hcl.Phase3End.exceptions.UserNotFoundException;
import com.hcl.Phase3End.repositories.UserRepository;





@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class)
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	

    public User GetUserByName(String username) {
        User foundUser = userRepository.findByUsername(username);
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

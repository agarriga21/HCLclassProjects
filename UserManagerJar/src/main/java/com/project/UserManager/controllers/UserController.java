package com.project.UserManager.controllers;



import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.UserManager.entities.User;
import com.project.UserManager.exceptions.UserNotFoundException;
import com.project.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/list")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting all Users");
		Iterable<User> users = userService.GetAllUsers();
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "list";
    }
    
  
    
	@PostMapping("/users")
	public String editUsers(ModelMap model, @RequestParam(value="id",defaultValue="0")int id) throws UserNotFoundException {
		
		 
		logger.info("Getting user");
		User user;
		
			user = userService.GetUserById(id);
			Iterable<User> users = Arrays.asList(user);
			
			
			logger.info("Passing user to view");
			
			
			model.addAttribute("id", id); 
		    model.addAttribute("user", users); 
		
		   
		
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(ModelMap model, @PathVariable("id") int id) throws UserNotFoundException{ 
        User user =userService.GetUserById(id); 
    	model.addAttribute("user",user);
        return "edit";
    }
    @PostMapping("/confirm")
    public String showConfirmPage(ModelMap model, User user){ 
        userService.UpdateUser(user);
        model.addAttribute("user",user);
    	return "confirm";
    }
}
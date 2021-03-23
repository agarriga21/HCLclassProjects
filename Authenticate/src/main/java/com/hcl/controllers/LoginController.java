package com.hcl.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.entities.User;
import com.hcl.exceptions.UserNotFoundException;
import com.hcl.services.UserService;







@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	 Logger logger = LoggerFactory.getLogger(LoginController.class);




    @GetMapping("/")
    public String showLogin(ModelMap map) {
        return "login";
    }



    
	@PostMapping("/login")
	public String editUsers(ModelMap model, @RequestParam String name, @RequestParam String password){
		
		 
		logger.info("Getting user");
		User user;
		try {
			user = userService.GetUserByName(name);
			
			if(userService.ValidPassword(password,user))
			
			{
		
		   
		
        return "Success";}
        	
			else {
				return "Invalid";
			}
    }
		catch(UserNotFoundException ex) {
			return "Nouser";
		}
}
}
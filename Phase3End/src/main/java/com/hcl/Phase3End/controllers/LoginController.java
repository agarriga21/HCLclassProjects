package com.hcl.Phase3End.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.Phase3End.entities.User;
import com.hcl.Phase3End.exceptions.UserNotFoundException;
import com.hcl.Phase3End.services.UserService;








@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	 Logger logger = LoggerFactory.getLogger(LoginController.class);




    @GetMapping("/login")
    public String showLogin(ModelMap model) {
        return "login";
    }

    @GetMapping("/register")
    public String showReg(ModelMap model) {
        model.addAttribute("user", new User());
    	return "register";
    }
    
	@PostMapping("/login")
	public String login(ModelMap model, @RequestParam String username, @RequestParam String password){
		
		 
		logger.info("Getting user");
		User user;
		try {
			user = userService.GetUserByName(username);
			
			if(userService.ValidPassword(password,user))
			
			{
		
		   
		
        return "redirect:/tasks/"+user.getID();}
        	
			else {
				model.put("errorMessage", "Password incorrect");
				return "login";
			}
    }
		catch(UserNotFoundException ex) {
			model.put("errorMessage", "Username does not exist");
			return "login";
		}
}
	 @PostMapping("/process")
	    public String register(ModelMap model, 
	    		@RequestParam String username, 
	    		@RequestParam String password,
	    		@RequestParam String email) {
		 User user = new User();
		user= userService.AddUser(username,password,email);
	
		if(user!=null) {
			model.put("successMessage", "The user was successfully created");
			return "register";
		}
		else {
			model.put("errorMessage", "This username is already being used");
			return "register";
		}
	    }
	
	 
}
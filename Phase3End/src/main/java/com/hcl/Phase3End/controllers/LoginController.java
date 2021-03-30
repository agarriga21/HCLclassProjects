package com.hcl.Phase3End.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String showLogin(ModelMap map) {
        return "login";
    }

    @GetMapping("/register")
    public String showReg(ModelMap map) {
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
		
		   
		
        return "usermenu";}
        	
			else {
				return "Invalid";
			}
    }
		catch(UserNotFoundException ex) {
			return "Nouser";
		}
}
	 @PostMapping("/register")
	    public String register(ModelMap model, 
	    		@RequestParam String username, 
	    		@RequestParam String password,
	    		@RequestParam String email) {
		User user = new User(1,"test","test","test");
		//int id = 0;
		//user.setId(id);
		//user.setUserName(username);
		//user.setPassword(password);
		//user.setEmail(email);
		model.addAttribute("user",user);
		 return "redirect:/usersuccess";
	    }
	 
	 @GetMapping("/usersuccess")
	    public String showConfirmPage(ModelMap model,@ModelAttribute("user") User user){ 
	       // userService.AddUser(user);
		 model.addAttribute(user);
	    	return "usersuccess";
	    }
	 
}
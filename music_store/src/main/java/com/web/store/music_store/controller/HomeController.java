package com.web.store.music_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
//	@GetMapping("/")
//	public ModelAndView index() {
//		ModelAndView model = new ModelAndView("index");
//		return model;
//	}//end of method 'index()
	
	@GetMapping("/")
	public String index() {
		return "main";
	}//end of method 'index()

	

}

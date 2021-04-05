package com.web.store.music_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.music_store.service.TempListService;

@Controller
public class TempListController {

	
	
	
	
	@Autowired
	private TempListService listService;
	
	
	
	 @GetMapping("/list")
	    public String showList(ModelMap model){ 
		model.put("albums", listService.GetAllAlbums());
		model.put("genres", listService.GetAllGenres());
		model.put("music", listService.GetAllMusic());
		 
		 
		 return "list";
	    }
}

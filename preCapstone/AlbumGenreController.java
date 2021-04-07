package com.web.store.music_store.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.web.store.music_store.model.AlbumGenre;
import com.web.store.music_store.service.AlbumGenreService;

@Controller
public class AlbumGenreController {

	@Autowired
	AlbumGenreService service;
	
	@PostMapping(value="/create")
	public String createAlbum(ModelMap model, @RequestParam String name, @RequestParam String artist, @RequestParam String price, 
			@RequestParam String release_date, @RequestParam String genre_name) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
		service.create(new AlbumGenre(name, artist, price, date, genre_name));
		model.put("message", "Album has been added");
		return "redirect:/readadmin";
	}
	
	@GetMapping(value="/readadmin")
	public String readTableAdmin(ModelMap model) throws ParseException {
		model.put("albums", service.read());
		return "adminlist";
	}
	
	@GetMapping(value="/readuser")
	public String readTableUser(ModelMap model) throws ParseException {
		model.put("albums", service.read());
		return "products";
	}
	
	@PostMapping(value="/update")
	public String updateAlbum(ModelMap model, @RequestParam int id, @RequestParam String name, @RequestParam String artist, @RequestParam String price, 
			@RequestParam String release_date, @RequestParam String genre_name) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
		service.update(id, name, artist, price, date, genre_name);
		model.put("message", "Album has been updated");
		return "redirect:/readadmin";
	}
	
	@PostMapping(value="/delete")
	public String deleteAlbum(ModelMap model, @RequestParam int id) throws ParseException {
		service.delete(id);
		model.put("message", "The album has been deleted");
		return "redirect:/readadmin";
	}
	
	@PostMapping(value="/search")
	public String searchAlbums(ModelMap model, @RequestParam String column, @RequestParam String value) throws ParseException {
		List<AlbumGenre> dis = service.search(column, value);
		for(AlbumGenre x : dis) {
			System.out.println(x.toString());
		}
		model.put("albums", service.search(column, value));
		return "products";
	}
	
	@GetMapping("/edit")
    public String showEditPage(ModelMap model, @RequestParam int id){ 
      AlbumGenre album= service.find(id);
    	model.addAttribute("album",album);
    	return "edit";
    }
	
}

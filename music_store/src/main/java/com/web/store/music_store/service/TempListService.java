package com.web.store.music_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.music_store.model.Album;
import com.web.store.music_store.model.Genre;
import com.web.store.music_store.model.Music;
import com.web.store.music_store.repository.AlbumRepository;
import com.web.store.music_store.repository.GenreRepository;
import com.web.store.music_store.repository.MusicRepository;


//To be able to create a list in the list.jsp



@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class)
public class TempListService {
	
	@Autowired
	 private AlbumRepository albumRepository;
	@Autowired
	 private GenreRepository genreRepository;
	@Autowired
	 private MusicRepository musicRepository;
	 
	public Iterable<Album> GetAllAlbums() //Get all the album table info
    {
       return albumRepository.findAll();
    }
	
	public Iterable<Genre> GetAllGenres() //Get all the genre table info
    {
        return genreRepository.findAll();
    }
	
	public Iterable<Music> GetAllMusic() //Get all the music table info
    {
        return musicRepository.findAll();
   }
}
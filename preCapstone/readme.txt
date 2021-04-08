Update 4/8/21 1:00 PM CST - Alexander Garriga

-Added the details page for specific album accessible through the user product view "/readuser"
For this page, I added another controller to AlbumGenreController.java as follows:

@GetMapping("/details")
    public String showDetailsPage(ModelMap model, @RequestParam int id){ 
      AlbumGenre album= service.find(id);
    	model.put("album",album);
    	return "details";
    }

Basically the same as the edit controller just instead for the details page.

- Changed the three search bars on user products page to one search bar with a drop down menu to choose what the user wants to search.

- Upgraded all of the pages with a backround and colors to make it look a lot better.


-----------------------------------------------------------------------------------------------------------------------------------------



Update 4/7/21 12:00 CST - Alexander Garriga

I was able to connect all of Bens functions to my jsp's.

My front end work is all in the webapp folder ready to be plugged into the main project, also have AlbumGenreController.java and AlbumGenreService.java with my minor changes.

adminlist.jsp can add an album, delete, and take the admin to an edit form (edit.jsp)

products.jsp can search by album, genre, and artist accessible through the nav bar.

index.jsp is the home link in the nave bar. This has a carasoul I made with concert pictures.

edit.jsp is the edit form when "edit" is pressed in adminlist.jsp. This forms autofills with the information with its corresponding albumID. Release Date however is not filling due to what I believe is a format issue when going from a java date to date type in html. 
(I got this to work in previous projects by just converting the MySQL date to String in the model/entity but that may mess up service methods so I can leave that to Ben to find the best way to fix) 

Small changes I made to Bens project, controller, and service class for connectivity:

-Had to remove security dependencies in pom.xml since I was restricted from post pages. Mas security implementation will fix this.

I changed readTable method to two methods readTableAdmin and readTableUser. Exact same code, just duplicated so they can be mapped to diffrent addresses and have the table added. Also made these GET since getting to these as a post was difficult (/readadmin and /readuser)

-I returned "redirect:/readadmin" for createAlbum, updateAlbum, and deleteAlbum to get back to the adminlist.jsp since without redirect, refreshing the page would mess with functionality. 

I added a controller method for the edit form:

@GetMapping("/edit")
    public String showEditPage(ModelMap model, @RequestParam int id){ 
      AlbumGenre album= service.find(id);
    	model.addAttribute("album",album);
    	return "edit";
    }

I basically copied the delete but made it GET as the form wouldnt load as post.

I added a service method for this edit form just to find one album by id as .find

 public AlbumGenre find(int id) {
		AlbumGenre album = repo.findById(id).get();
		return album;
	}

again copied the delete just added "album =" and return value

Bens service methods and controller logically worked flawlessly once connected.

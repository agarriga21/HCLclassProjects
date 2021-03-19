package com.example.Feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Feedback.entities.Feedback;
import com.example.Feedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/feedback")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.GetAllFeedback();
    }
	
	@PostMapping("/feedback")
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) {
		
		if(!newFeedback.getComments().isBlank()&&!newFeedback.getUser().isBlank()
				&&0<newFeedback.getRating()&&newFeedback.getRating()<11) {
			feedbackService.SaveFeedback(newFeedback);
			newFeedback.getId();
		}
		else {
			newFeedback.setComments("Your input was invalid, this feedback was not added to the database.");
		}
	
	return newFeedback;
	}
	

}
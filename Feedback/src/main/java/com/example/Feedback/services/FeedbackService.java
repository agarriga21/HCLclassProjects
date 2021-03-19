package com.example.Feedback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Feedback.entities.Feedback;
import com.example.Feedback.repositories.*;


@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Iterable<Feedback> GetAllFeedback() {
		return feedbackRepository.findAll();
	}
	 public void SaveFeedback(Feedback newFeedback) {
	    	feedbackRepository.save(newFeedback);
	    }


}
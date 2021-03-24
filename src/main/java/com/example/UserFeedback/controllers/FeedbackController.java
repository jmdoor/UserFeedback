package com.example.UserFeedback.controllers;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	
	
	@GetMapping("/feedback")
	public Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.GetAllFeedback();
    }
	
	@PostMapping("/feedback")
	public Feedback addNewFeedback(ModelMap model, @RequestParam("user") String user, @RequestParam("comments") String comments, @RequestParam("rating") int rating) {
		// TODO: Do something useful here.  
		// Add the Feedback.
		Feedback newFeedback = new Feedback(); 
		newFeedback.setUser(user);
		newFeedback.setComments(comments);
		newFeedback.setRating(rating);
		feedbackService.addFeedback(newFeedback);
		return new Feedback();  
	}
	

}

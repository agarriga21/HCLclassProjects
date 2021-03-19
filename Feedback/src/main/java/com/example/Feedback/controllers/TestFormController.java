package com.example.Feedback.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Feedback.entities.Feedback;
@Controller
public class TestFormController {
	@GetMapping("/")
	public String showTestForm(ModelMap model) {
        // This returns a JSON or XML with the Feedbacks
        return "testform.html";
    }
}

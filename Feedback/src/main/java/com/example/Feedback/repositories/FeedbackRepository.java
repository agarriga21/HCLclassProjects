package com.example.Feedback.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Feedback.entities.*;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{
}
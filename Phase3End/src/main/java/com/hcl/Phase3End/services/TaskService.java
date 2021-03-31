package com.hcl.Phase3End.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.Phase3End.entities.Task;
import com.hcl.Phase3End.repositories.TaskRepository;
import com.hcl.Phase3End.repositories.UserRepository;




@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class)
public class TaskService {
	
	@Autowired
	 private TaskRepository taskRepository;
	
	 public List<Task> GetUserTasks(int userId)
	    {
		 Iterable<Task> totalTasks = taskRepository.findAll();; 
		List<Task> userTasks = new ArrayList<Task>();
		for(Task task : totalTasks) {
			if(task.getUserid()==userId) {
				
				userTasks.add(task);
			}
		}
		 
		 
		 return userTasks;
	    }

	 public void UpdateTask(Task tasktoUpdate) {
	    	taskRepository.save(tasktoUpdate);
	    }
	 public Task GetTaskById(int id) {
	    	
	    	Optional<Task> foundUser = taskRepository.findById(id);
	    	
	    	
	    	return(foundUser.get());
	    }
	 public void deleteTask(int id) {
			Task task = taskRepository.findById(id).get();
			taskRepository.delete(task);
		}
	 public void createTask(Task task) {
			
		 
		 taskRepository.save(task);
		}
}

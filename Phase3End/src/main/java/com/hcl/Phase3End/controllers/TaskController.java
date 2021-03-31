package com.hcl.Phase3End.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.Phase3End.entities.Task;
import com.hcl.Phase3End.services.TaskService;
import com.hcl.Phase3End.services.UserService;



@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	 @GetMapping("/tasks/{userid}")
	    public String showUserTask(@PathVariable("userid") int userid, ModelMap model){ 
		model.put("usertasks", taskService.GetUserTasks(userid));
		model.put("userid", userid);
		 
		 
		 return "tasks";
	    }
	 @GetMapping("/edit/{userid}/{id}")
	    public String showEditPage(ModelMap model,@PathVariable("userid") int userid, @PathVariable("id") int id){ 
	        Task task =taskService.GetTaskById(id); 
	    	model.addAttribute("task",task);
	    	model.put("userid", userid);
	    	return "edit";
	    }
	    @PostMapping("/editted/{userid}/{id}")
	    public String edditted(ModelMap model, Task task,@PathVariable("userid") int userid, @PathVariable("id") int id){ 
	        taskService.UpdateTask(task);
	        model.addAttribute("task",task);
	        model.put("userid", userid);
	        model.put("id", id);
	    	return "redirect:/tasks/"+userid;
	    }
	    @GetMapping("/delete/{userid}/{id}")
	    public String delete(ModelMap model, Task task,@PathVariable("userid") int userid,@PathVariable("id") int id){ 
	        taskService.deleteTask(id);
	       
	        model.put("userid", userid);
	        model.put("id", id);
	    	return "redirect:/tasks/"+userid;
	    }
	    @GetMapping("/create/{userid}")
	    public String create(@PathVariable("userid") int userid, ModelMap model){ 
	    	model.put("userid", userid);
		return "create";
}
	    @PostMapping("/created/{userid}")
	    public String created(ModelMap model,@PathVariable("userid") int userid,
	    		@RequestParam String taskname, 
	    		@RequestParam String description,
	    		@RequestParam String start,
	    		@RequestParam String end,
	    		@RequestParam String severity){ 
	       Task newTask = new Task();
	       newTask.setUserid(userid);
	       newTask.setTaskName(taskname);
	       newTask.setDescription(description);
	       newTask.setStart(start);
	       newTask.setEnd(end);
	       newTask.setSeverity(severity);
	    	
	    	
	    	
	    	taskService.createTask(newTask);
	        
	        model.put("userid", userid);
	    	return "redirect:/tasks/"+userid;
	    }
}
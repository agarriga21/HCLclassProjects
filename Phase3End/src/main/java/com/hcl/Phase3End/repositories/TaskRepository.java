package com.hcl.Phase3End.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hcl.Phase3End.entities.Task;
import com.hcl.Phase3End.entities.User;

public interface TaskRepository extends CrudRepository<Task, Integer> {

 

}

package com.hcl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.hcl.entities.User;
import com.hcl.exceptions.UserNotFoundException;
import com.hcl.services.UserService;

@SpringBootTest
class AuthenticateApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}
	@Test
	void testServiceCall() {
		Iterable<User> users = userService.GetAllUsers();
		Integer count = 0;
		for(User u : users) {
			count++;
		}
		assertNotEquals(count, 0);
	}
	 @Test
	    public void testExistingUserByName() {
	        // given

	        User dummyUser = new User(); //existing user
	        dummyUser.setId(1);
	        dummyUser.setName("admin");
	        dummyUser.setEmail("admin@test.com");
	        dummyUser.setPassword("admin");
	       

	        // when
	        User found = userService.GetUserByName(dummyUser.getName());

	        // then

	        assertEquals(found.getName(), dummyUser.getName());
	    }
	  @Test
	    public void testExistingUserByValidPass() {
	        // given

	        User dummyUser = new User();
	      
	        dummyUser.setId(1);
	        dummyUser.setName("admin");
	        dummyUser.setEmail("admin@test.com");
	        dummyUser.setPassword("admin");
	      
	        User found = userService.GetUserByName(dummyUser.getName());
	      boolean validPass = userService.ValidPassword(dummyUser.getPassword(), found);
	        

	        // then
	        assertEquals(true,validPass);
	       
	    }
	  @Test
	    public void testExistingUserByInvalidPass() {
	        // given

	        User dummyUser = new User();
	      
	        dummyUser.setId(1);
	        dummyUser.setName("admin");
	        dummyUser.setEmail("admin@test.com");
	        dummyUser.setPassword("wrong");
	      
	        User found = userService.GetUserByName(dummyUser.getName());
	      boolean validPass = userService.ValidPassword(dummyUser.getPassword(), found);
	        

	        // then
	        assertEquals(false,validPass);
	       
	    }
	  @Test
	    public void testNonExistingUserByName() {
	        // given

	        User dummyUser = new User(); //non existing user
	        dummyUser.setId(100);
	        dummyUser.setName("test");
	        dummyUser.setEmail("test@test.com");
	        dummyUser.setPassword("admin");
	       boolean exist;

	        try {
	        User found = userService.GetUserByName(dummyUser.getName());
	        exist=true;
	        }
	        catch(UserNotFoundException unfe) {
	        	exist=false;
	        }

	        assertEquals(false,exist);
	    }
}

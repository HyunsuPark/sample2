package com.data.mongo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.data.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class test1 {

	@Inject
	MongoOperations mongoOperation;
	
	@Test
	public void addAndGet() throws Exception {
		
		
		for (int i = 0; i < 10; i++) {
			User user = new User();
			
			user.setId("ekrnfkdi"+i);
			user.setPassword("1111");
			user.setUserName("park");
			
			// save
			mongoOperation.save(user);
		}
		
		List<User> listUser1 = mongoOperation.findAll(User.class);
		
		for (User user : listUser1) {
			System.out.println(user.getId());
		}
		
		Query searchUserQuery = new Query(Criteria.where("userName").is("park"));
	 
		// find the saved user again.
		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + savedUser);
	 
		// update password
		mongoOperation.updateFirst(searchUserQuery, 
	                         Update.update("password", "new password"),User.class);
	 
		// find the updated user object
		User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);
	 
		System.out.println("3. updatedUser : " + updatedUser);
	 
		// delete
//		mongoOperation.remove(searchUserQuery, User.class);
	 
		// List, it should be empty now.
		List<User> listUser = mongoOperation.findAll(User.class);
		System.out.println("4. Number of user = " + listUser.size());
	}	

}
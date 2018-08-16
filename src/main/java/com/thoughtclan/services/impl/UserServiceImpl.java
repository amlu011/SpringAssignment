package com.thoughtclan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.dao.SportsRepositoryUser;
import com.thoughtclan.models.User;
import com.thoughtclan.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired SportsRepositoryUser sportsRepositoryUser;
	
	@Override
	public boolean addUser(User user) {
		Iterable<User> users= sportsRepositoryUser.findAll();
		
		boolean flag=true;
		for(User u:users) {
			if(u.getUserEmail().equals(user.getUserEmail())) {
				flag=false;
			}
			
			
		}
		if(flag==true) {
			sportsRepositoryUser.save(user);
		}
			
			
		return flag;

	}
	
	/**
	 * returns a boolean value representing if the user is already present
	 */
	@Override
	public boolean findUser(String userEmail,String userName) {
		boolean flag=false;
		Iterable<User> users= sportsRepositoryUser.findAll();
		for(User u:users) {
			if(u.getUserEmail().equals(userEmail)) {
				if(u.getUserName().equals(userName)) {
					flag=true;
				}
			}
		}
		return flag;
	}

}

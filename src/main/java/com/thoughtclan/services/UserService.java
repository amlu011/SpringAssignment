package com.thoughtclan.services;

import com.thoughtclan.models.User;

public interface UserService {

	public boolean addUser(User user);
	public boolean findUser(String userEmail,String userName);

}

package com.thoughtclan.dao;

import org.springframework.data.repository.CrudRepository;

import com.thoughtclan.models.User;

public interface SportsRepositoryUser extends CrudRepository<User,String> {

}

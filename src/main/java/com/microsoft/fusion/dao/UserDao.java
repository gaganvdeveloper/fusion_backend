package com.microsoft.fusion.dao;

import java.util.List;

import java.util.Optional;

import com.microsoft.fusion.entity.User;

public interface UserDao {
  
	User saveUser(User user);
	
  List<User> findAllUsers();
	
  Optional<User> findUserById(int uid);

}

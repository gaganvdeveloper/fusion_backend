package com.microsoft.fusion.dao;

import java.util.Optional;

import com.microsoft.fusion.entity.User;

public interface UserDao {

	Optional<User> findUserById(int uid);

}

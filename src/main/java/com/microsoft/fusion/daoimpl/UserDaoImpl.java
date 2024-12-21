package com.microsoft.fusion.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microsoft.fusion.dao.UserDao;
import com.microsoft.fusion.entity.User;
import com.microsoft.fusion.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;

	@Override
	public Optional<User> findUserById(int uid) {
		return repository.findById(uid);
	}

}

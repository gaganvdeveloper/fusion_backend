package com.microsoft.fusion.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.UserDao;
import com.microsoft.fusion.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao userDao;
	
}

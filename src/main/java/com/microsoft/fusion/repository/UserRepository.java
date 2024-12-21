package com.microsoft.fusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsoft.fusion.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

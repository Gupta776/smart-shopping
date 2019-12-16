package com.smartshopping.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartshopping.authenticationservice.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByUserName(String userName);
}
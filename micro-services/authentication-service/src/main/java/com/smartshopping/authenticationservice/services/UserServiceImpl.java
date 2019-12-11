//package com.smartshopping.authenticationservice.services;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.smartshopping.authenticationservice.model.Users;
//import com.smartshopping.authenticationservice.repository.UsersRepository;
//
//@Service
//public class UserServiceImpl implements UserService  {
//	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
//
//	@Autowired
//	UsersRepository usersRepository;
////	@Autowired
////	PasswordEncoder passwordEncoder;
//	@Override
//	public void signup(Users user) {
//		//to get the data from front end and send to back end from repository save function
//		//user.setPassword(passwordEncoder.encode(user.getPassword()));
//	usersRepository.save(user);
//		
//	}
//
//}

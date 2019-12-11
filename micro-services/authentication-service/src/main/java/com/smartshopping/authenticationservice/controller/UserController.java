package com.smartshopping.authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopping.authenticationservice.exception.UserAlreadyExistException;
import com.smartshopping.authenticationservice.model.Users;
import com.smartshopping.authenticationservice.security.AppUserDetailsService;
//import com.smartshopping.authenticationservice.services.UserService;


@RestController
@RequestMapping("/smart-shopping/users")
//@CrossOrigin("*")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@PostMapping
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistException {
		LOGGER.info("Start");
		LOGGER.debug("signup"+user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		userService.signup(user);
		appUserDetailsService.signup(user);
		LOGGER.info("End");
	}
}

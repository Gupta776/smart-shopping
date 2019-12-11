package com.smartshopping.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopping.productservice.model.Users;
import com.smartshopping.productservice.security.AppUserDetailsService;

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
//	@PostMapping
//	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistException {
//		LOGGER.info("Start");
//		LOGGER.debug("signup"+user);
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
////		userService.signup(user);
//		appUserDetailsService.signup(user);
//		LOGGER.info("End");
//	}
	
//	@PutMapping()
	@GetMapping("/all-admins")
	public List<Users> getAllAdminList() {
		LOGGER.info("Start");
		LOGGER.info("end");
		return appUserDetailsService.getAllAdminList();
		
	}
	
	@PutMapping("/approve")
	public void approveAdmin(@RequestBody @Valid Users user) {
		System.out.println(user);
		LOGGER.info("Start");
		appUserDetailsService.approveAdmin(user);
		LOGGER.info("end");
		
			
		}
	
	@GetMapping("/all-users")
	public List<Users> allUsers() {
		LOGGER.info("Start");
		LOGGER.info("end");
		return appUserDetailsService.getAllUsersList();
	}
	
	
	@GetMapping("/{userName}")
	public Users userItem(@PathVariable("userName") @Valid String userName) {
		LOGGER.info("Start");
		LOGGER.info("end");
		System.out.println(userName);
		return appUserDetailsService.getUserItem(userName);
	}
	@GetMapping("/user/{id}")
	public Users userById(@PathVariable("id") @Valid int id) {
		LOGGER.info("Start");
		LOGGER.info("end");
		System.out.println(id);
		return appUserDetailsService.getUserItemById(id);
	}
	@GetMapping("/user1/{userName}")
	public Users getUserByUserID(@PathVariable String userName) {
		return appUserDetailsService.getUserByUserID(userName);
	}
	
	@GetMapping("/contact-number/{contactNumber}")
	public Users getUserByContactNumber(@PathVariable long contactNumber) {
		System.out.println(contactNumber);
		return appUserDetailsService.getUserByContactNumber(contactNumber);
	}
	@PutMapping("/new-password")
	public void updatePassword(@RequestBody @Valid Users user)  {
		LOGGER.info("Start");
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		appUserDetailsService.updateUser(user);
		LOGGER.info("End");
	}
	
}
	


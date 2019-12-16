package com.smartshopping.authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartshopping.authenticationservice.controller.UserController;
import com.smartshopping.authenticationservice.exception.UserAlreadyExistException;
import com.smartshopping.authenticationservice.model.Users;
import com.smartshopping.authenticationservice.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUserName(username);
		LOGGER.debug("ASD" + user);
		if (user == null) {
			System.out.println("1" + user);
			LOGGER.debug("user is null - loadbyusername");
			throw new UsernameNotFoundException("user not found");
		} else {
			System.out.println(user);
			System.out.println("LL" + new AppUser(user));
			return new AppUser(user);
		}

	}

	public AppUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@Transactional
	public void signup(Users user) throws UserAlreadyExistException  {
		//boolean flag = false;
		
		System.out.println("data bse serach in appuserderails");
		System.out.println(usersRepository.findByUserName(user.getUserName()));
		if (usersRepository.findByUserName(user.getUserName()) != null) {
			//flag = false;
			throw new UserAlreadyExistException();
		} else {
			//flag = true;
			// Set<Role> role = new HashSet();
			// role.add(new Role(1, "user"));
			// user.setRoleList(role);
			usersRepository.save(user);
		}
		// return flag;
	}

}
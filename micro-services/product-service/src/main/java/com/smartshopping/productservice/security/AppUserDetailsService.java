package com.smartshopping.productservice.security;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartshopping.productservice.model.Users;
import com.smartshopping.productservice.repository.UsersRepository;

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
//		System.out.println(user);
		if (user == null) {
			System.out.println("1" + user);
			LOGGER.debug("user is null - loadbyusername");
			throw new UsernameNotFoundException("user not found");
		} else {
			System.out.println(user);
			System.out.println("LL" + new AppUser(user));
			return new AppUser(user);
		}
//		LOGGER.debug("return");

	}

	public AppUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

//	@Transactional
//	public void signup(Users user) {
//		//boolean flag = false;
//		
//		System.out.println("data bse serach in appuserderails");
//		System.out.println(usersRepository.findByUserName(user.getUserName()));
//		if (usersRepository.findByUserName(user.getUserName()) != null) {
//			//flag = false;
//		} else {
//			//flag = true;
//			// Set<Role> role = new HashSet();
//			// role.add(new Role(1, "user"));
//			// user.setRoleList(role);
//			usersRepository.save(user);
//		}
//		// return flag;
//	}
	
	
	@Transactional
	public List<Users> getAllAdminList(){
		LOGGER.info("Start");
		LOGGER.info("End");
		return usersRepository.getAllAdmins();
	}
	@Transactional
	public void approveAdmin(Users user) {
		usersRepository.save(user);
	}
	@Transactional
	public List<Users> getAllUsersList() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return usersRepository.getAllUsers();
	}
	@Transactional
	public Users getUserItem(String userName) {
		LOGGER.info("Start");
		LOGGER.info("End");
		System.out.println(usersRepository.getUserItem(userName));
		return usersRepository.getUserItem(userName);
	}
	@Transactional
	public Users getUserItemById(@Valid int id) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return usersRepository.findById(id).get();
	}
	@Transactional
	public Users getUserByContactNumber(long contactNumber) {
		// TODO Auto-generated method stub
		return usersRepository.findByContactNumber(contactNumber);
	}
	@Transactional
	public void updateUser(@Valid Users user) {
		// TODO Auto-generated method stub
		usersRepository.save(user);
	}
	@Transactional
	public Users getUserByUserID(String userID) {
		return usersRepository.findByUserName(userID);
	}
}
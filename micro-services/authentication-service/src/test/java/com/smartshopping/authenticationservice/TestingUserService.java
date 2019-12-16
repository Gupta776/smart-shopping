package com.smartshopping.authenticationservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartshopping.authenticationservice.exception.UserAlreadyExistException;
import com.smartshopping.authenticationservice.model.Users;
import com.smartshopping.authenticationservice.repository.UsersRepository;
import com.smartshopping.authenticationservice.security.AppUserDetailsService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestingUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestingUserService.class);
	UsersRepository repository = Mockito.mock(UsersRepository.class);
 	AppUserDetailsService service = new AppUserDetailsService(repository);
 
 	@Test
 	public void mockTestLoadUserByUsername() {
 		LOGGER.info("Start");
 		when(repository.findByUserName("admin")).thenReturn(createUser());
 		UserDetails user = service.loadUserByUsername("admin");
 		String expected = "$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS";
 		assertEquals(expected, user.getPassword());
 		LOGGER.info("End");
 	}
 	private Users createUser() {
 		Users user = new Users(2,"admin","admin",21,"Male",735,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa",0);
 		return user;
 	}
 	@Test(expected = UsernameNotFoundException.class)
 	public void testLoadByUserNameNotFoundException() throws UsernameNotFoundException {
 		when(repository.findByUserName("rohith")).thenReturn(null);
 		service.loadUserByUsername("rohith");
 	}
 	@Test(expected = UserAlreadyExistException.class)
 	public void testForUserExist() throws UserAlreadyExistException {
 		LOGGER.info("Start");
 		Users user = new Users(1, "Admin", "Admin", 30, "Male", 1111111111, "admin", "$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS", "O", "A", "What is your favorite book ", "Robotics", "What is your lucky item", "Cake", "What is your favorite movie", "kingkong",0);
 		when(repository.findByUserName("admin")).thenReturn(user);
 		service.signup(user);
 		LOGGER.info("End");
 	}
 	@Test
 	public void newSignUp() throws UserAlreadyExistException {
 		LOGGER.info("Start");
 		when(repository.findByUserName("rohith")).thenReturn(null);
 		Users user = new Users(2, "rohith", "narjala", 21,"Male",0, null,"rohith",
 				"$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",null,null,null,null,null,null,null,0);
 		service.signup(user);
 		LOGGER.info("End");
 
 	}
}

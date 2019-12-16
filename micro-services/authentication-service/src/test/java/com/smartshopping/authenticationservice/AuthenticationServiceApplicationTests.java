package com.smartshopping.authenticationservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.smartshopping.authenticationservice.controller.UserController;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class AuthenticationServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	UserController userController;
	
//	@Test
//	public void getAllUsers() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shopping/users")).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void getUser() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shopping/users/4")).andExpect(status().isOk());
//	}
}

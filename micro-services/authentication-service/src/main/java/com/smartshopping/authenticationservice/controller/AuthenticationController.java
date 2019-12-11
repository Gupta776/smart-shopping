package com.smartshopping.authenticationservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopping.authenticationservice.security.AppUserDetailsService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/smart-shopping")
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	
	@GetMapping("/authentication")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("start");
		LOGGER.debug(authHeader);
		Map<String, String> data = new HashMap<>();
		//String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		UserDetails userDetails = appUserDetailsService.loadUserByUsername(userName);
		System.out.println(userName);
		String userType=SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		String status =SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[1].toString();
		String firstName=SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[2].toString();
		System.out.println(userType);
		data.put("token", generateJwt(getUser(authHeader)));
		data.put("userName", userName);
		data.put("userType", userType);
		data.put("status",status );
		data.put("firstName", firstName);
		LOGGER.info("End");
		LOGGER.debug("sad"+data);
		return data;
	}

	private String getUser(String authHeader) {
		LOGGER.info("start");
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.info("End");
		return decodedCredentials.split(":")[0];
	}

	private String generateJwt(String user) {
		LOGGER.info("start");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		LOGGER.info("End");
		return token;
	}
}
package com.smartshopping.authenticationservice.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartshopping.authenticationservice.model.Users;

public class AppUser implements UserDetails {
	private Users user;
	private Collection<? extends GrantedAuthority> authorities; // to store role details

	public AppUser(Users user) {
		System.out.println(user);
		this.user = user;
		List<String> roleList = new ArrayList<String>();
		roleList.add(user.getUserType());
		roleList.add(user.getStatus());
		roleList.add(user.getFirstName());
		this.authorities = roleList.stream().map(value -> new SimpleGrantedAuthority((value)))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

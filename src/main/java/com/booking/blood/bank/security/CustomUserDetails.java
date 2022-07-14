package com.booking.blood.bank.security;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.booking.blood.bank.model.Users;


public class CustomUserDetails implements UserDetails {

	private String username;
	private String password;
	private boolean active;
	private int id;
	private List<GrantedAuthority> authotities;
	
	
	
	CustomUserDetails(Users user){
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.id = user.getId();
		this.authotities = Stream.of(user.getRoles().split(",")).map(x->{
			return new SimpleGrantedAuthority(x);
		}).collect(Collectors.toList());
		
		
	}

	

	public int getId() {
		return id;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authotities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}


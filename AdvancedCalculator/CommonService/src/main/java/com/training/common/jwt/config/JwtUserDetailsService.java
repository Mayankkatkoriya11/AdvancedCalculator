package com.training.common.jwt.config;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService 
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		if ("mayank".equals(username)) 
		{
			return new User("mayank", "$2a$10$Myfk0.OiPsPiq.2Owj.b3OLJ7FOgv1jdcLwCOOA7BCKzDl7YLVsRS",
					new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}

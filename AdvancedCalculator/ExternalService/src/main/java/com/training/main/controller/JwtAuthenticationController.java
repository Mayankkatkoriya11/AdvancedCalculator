package com.training.main.controller;


import javax.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.common.jwt.config.JwtTokenUtil;
import com.training.common.jwt.config.JwtUserDetailsService;
import com.training.common.jwt.dto.JwtRequest;
import com.training.common.jwt.dto.JwtResponse;
import com.training.common.service.dto.Request;
import com.training.computedate.dto.DateResponseDTO;
import com.training.computepower.dto.PowerResponseDTO;
import com.training.main.dto.DateResponse;
import com.training.main.dto.PowerResponse;


@RestController
@CrossOrigin
public class JwtAuthenticationController {
	
	private AuthenticationManager authenticationManager = new AuthenticationManager() {
		
		@Override
		public Authentication authenticate(Authentication authentication) throws AuthenticationException {
			// TODO Auto-generated method stub
			return null;
		}
	};

	private JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

	private JwtUserDetailsService userDetailsService = new JwtUserDetailsService();
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception 
	{
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception 
	{
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} 
		catch (DisabledException e) 
		{
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) 
		{
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	PowerResponse powerResponse = new PowerResponse();
	
	
	DateResponse dateResponse = new DateResponse();
	
	PowerResponseDTO powerresp = new PowerResponseDTO();
	
	DateResponseDTO dateresp = new DateResponseDTO();
	
	@RequestMapping(value = "/compute", method = RequestMethod.POST)
	public ResponseEntity<?> compute(@Valid @RequestBody Request request)throws Exception 
	{	
		if(request.getService().equals("computePower"))
		{
			 String url = "http://localhost:8081/computePower";
			 RestTemplate rest = new RestTemplate();
			 powerresp = rest.postForObject(url, request, PowerResponseDTO.class);
			 powerResponse.setPower(powerresp.getResult().toString());
			 
			 return ResponseEntity.ok(powerresp);
		}
		else if (request.getService().equals("computeDate"))
		{
			String url = "http://localhost:8082/computeDate";
			 RestTemplate res = new RestTemplate();
			 dateresp = res.postForObject(url, request, DateResponseDTO.class);
			 dateResponse.setDate(dateresp.getResult().toString());
			 
			 return ResponseEntity.ok(dateresp);
			
		}
		return null;
		
	}
}
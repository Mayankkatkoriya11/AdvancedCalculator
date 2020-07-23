package com.training.computedate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.computedate.dto.Request;
import com.training.computedate.service.impl.ComputeDateImpl;

@RestController
public class ComputeDateController {

	@Autowired
	private ComputeDateImpl computeDateImpl;
	
	@RequestMapping(value = "/computeDate", method =  RequestMethod.POST)
	public ResponseEntity<?> computeDate(@RequestBody Request request) throws Exception{
		return computeDateImpl.computeDate(request);
	}
}

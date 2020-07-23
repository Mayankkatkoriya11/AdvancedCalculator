package com.training.computepower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.computepower.dto.Request;
import com.training.computepower.sevice.impl.ComputePowerImpl;
import com.training.computepower.dto.PowerResponseDTO;

@RestController
public class ComputePowerController {

	@Autowired
	private ComputePowerImpl computePowerService;
	
	@RequestMapping(value = "/computePower", method = RequestMethod.POST)
	public PowerResponseDTO computePower(@RequestBody Request request) throws Exception{
		
		PowerResponseDTO result = computePowerService.calculatePower(request);
		return result;
	}
}

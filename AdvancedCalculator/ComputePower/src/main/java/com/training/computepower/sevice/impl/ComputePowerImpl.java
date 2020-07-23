package com.training.computepower.sevice.impl;

import org.springframework.stereotype.Service;

import com.training.computepower.dto.Request;
import com.training.computepower.dto.PowerResponseDTO;

@Service
public class ComputePowerImpl {

	public PowerResponseDTO calculatePower(Request request) throws Exception {
		
		double num1 = Double.parseDouble(request.getParam1());
		double num2 = Double.parseDouble(request.getParam2());
		
		double result = Math.pow(num1, num2);
		
		PowerResponseDTO resp = new PowerResponseDTO();
		resp.setResult(result);
		
		return resp;
	}
}

package com.training.common.service.dto;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request 
{
	private String service;
	
	private String param1;
	
	private String param2;
	
}

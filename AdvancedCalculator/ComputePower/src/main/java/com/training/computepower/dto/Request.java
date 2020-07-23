package com.training.computepower.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable{

	private static final long serialVersionUID = 1L;

	private String service;
	
	@NotEmpty
	private String param1;
	
	@NotEmpty
	private String param2;
}

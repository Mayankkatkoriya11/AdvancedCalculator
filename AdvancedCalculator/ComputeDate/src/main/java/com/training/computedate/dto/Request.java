package com.training.computedate.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable{

	private static final long serialVersionUID = 1L;

	private String service;
	
	@NotNull(message = "Please provide a date")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String param1;
	
	@NotNull(message = "Please provide a date")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String param2;
}

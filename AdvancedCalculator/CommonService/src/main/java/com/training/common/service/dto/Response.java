package com.training.common.service.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String response = "";
	private String responseCode = "";
	private String responseDesc ="";
}

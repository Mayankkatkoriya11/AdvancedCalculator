package com.training.computedate.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double result;
}

package com.training.computedate.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.computedate.dto.Request;
import com.training.computedate.dto.DateResponseDTO;


@Service
public class ComputeDateImpl {

	public ResponseEntity<?> computeDate(Request request) throws Exception{
			
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");
		
		String Date1 = request.getParam1();
		String Date2 = request.getParam2();

			Date dateBefore = myFormat.parse(Date1);
			Date dateAfter = myFormat.parse(Date2);
			
			long diff = dateAfter.getTime() - dateBefore.getTime();
			long result = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
			if(result >=365) 
			{	
				result = result / 365;
			}
			
			DateResponseDTO resp = new DateResponseDTO();
			
			resp.setResult((double)result);
			
			return ResponseEntity.ok(resp);
	}
}

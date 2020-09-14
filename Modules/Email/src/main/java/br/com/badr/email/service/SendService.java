package br.com.badr.email.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.badr.common.entity.Email;

@Service
public class SendService {

	public void send(Email email) {
		ObjectMapper mapper = new ObjectMapper();
		try {
		  String json = mapper.writeValueAsString(email);
		  System.out.println("ResultingJSONstring = " + json);
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		}
	}
	
}

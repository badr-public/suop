package br.com.badr.common.services;

import org.springframework.stereotype.Service;

@Service
public class MessageReferenceService {

	public String getNewMessageReference() {
		return Math.random() + "";
	}
	
}

package br.com.badr.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badr.common.entity.Email;
import br.com.badr.email.service.SendService;

@RestController
@RequestMapping("/send")
public class SendController {
	
	@Autowired
	private SendService service;

	@PostMapping()
	public void send(@RequestBody Email email) {
		service.send(email);
	}
	
}

package br.com.badr.commondata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badr.common.entity.User;
import br.com.badr.commondata.services.UserServiceInternal;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInternal service;
	
	@GetMapping("/list")
	public Iterable<User> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/update")
	public User newUser(@RequestBody User user) {
		return service.save(user);
	}
	
}

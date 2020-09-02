package br.com.badr.gw.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.badr.common.entity.Response;
import br.com.badr.common.entity.User;
import br.com.badr.common.services.UserService;
import br.com.badr.gw.control.PendingRequestControl;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	UserService service;

	@GetMapping("/list")
	public List<User> getAllUsers() {
		return null;
	}
	
	@GetMapping("/new")
	public User newUserSync(
			@RequestParam(name = "id", required = false) Integer id, 
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password) throws InterruptedException {
		User user = new User();
		user.id = id;
		user.username = username;
		user.email = email;
		user.password = password;
		
		String messageReference = service.newUser(user);
		Response response = new Response();
		PendingRequestControl.get().add(messageReference, response);
		
		synchronized (response) {
			response.wait(5000);
		}
		
		return (User) response.obj;
	}
	
}

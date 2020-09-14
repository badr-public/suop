package br.com.badr.commondata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.badr.common.entity.User;
import br.com.badr.commondata.repository.UserRepository;

@Service
public class UserServiceInternal {

	@Autowired
	private UserRepository repository;
	
	public Iterable<User> getAll() {
		return repository.findAll();
	}
	
	public User save(User user) {
		return repository.save(user);
	}
}

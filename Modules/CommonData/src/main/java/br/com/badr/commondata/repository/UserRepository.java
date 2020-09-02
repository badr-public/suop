package br.com.badr.commondata.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.badr.common.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}

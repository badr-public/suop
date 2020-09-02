package br.com.badr.common.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -1870456360454710965L;
	
	@Id
	@GeneratedValue
	public Integer id;
	public String username;
	public String email;
	public String password;
	
}

package com.sheena.defectapiproject.resource;

import com.sheena.defectapiproject.models.*;
import com.sheena.defectapiproject.repository.UsersRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersResource {

	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping(value = "/")
	public List<Users> getAll()
	{
		return usersRepository.findAll();
	}
	
	@PostMapping(value = "/register")
	public Boolean addUser(@RequestBody final Users users){
	Users u = usersRepository.findByUsername(users.getUsername());
	//System.out.println(u);
	if(u==null)
	{
		usersRepository.save(users);
		return true;
	}
	else
	return false;
	}
	
	@PostMapping(value = "/login")
	public Boolean authenticateUser(@RequestBody final Users user){
	return (usersRepository.findByEmailAndPassword(user.getUsername(),user.getPassword())!=null);
	}

	@GetMapping(value = "/{username}")
	public Users getUserProfile(@PathVariable String username)
	{
		return usersRepository.findByUsername(username);
	}
}

package com.udemy.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService daoService;

	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return daoService.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User findOne = daoService.findOne(id);
		if(findOne==null) {
			throw new UserNotFoundException("User id "+id+" id not found");
		}
		return findOne;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User save = daoService.save(user);
		URI currentRequest = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId())
				.toUri();
		return ResponseEntity.created(currentRequest).build();
	}
}

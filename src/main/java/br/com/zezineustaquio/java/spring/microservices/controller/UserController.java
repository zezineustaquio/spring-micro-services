package br.com.zezineustaquio.java.spring.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zezineustaquio.java.spring.microservices.db.entity.UserEntity;
import br.com.zezineustaquio.java.spring.microservices.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
@Api(tags = { "User" })
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	@ApiOperation(value = "List all users")
	public ResponseEntity<Page<UserEntity>> listUsers(@RequestParam int page, @RequestParam int size) {
		return service.listUsers(page, size);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get specific User by ID")
	public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
		return service.getUser(id);
	}

}

package br.com.zezineustaquio.java.spring.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.zezineustaquio.java.spring.microservices.db.entity.UserEntity;
import br.com.zezineustaquio.java.spring.microservices.db.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public ResponseEntity<Page<UserEntity>> listUsers(int page, int size) {
		Page<UserEntity> users = repository.findAll(PageRequest.of(page, size));
		if (!users.hasContent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users);
		}
		return ResponseEntity.ok(users);
	}

	public ResponseEntity<UserEntity> getUser(Long id) {
		return repository.findById(id) //
				.map(ResponseEntity::ok) //
				.orElse(ResponseEntity.notFound().build());
	}

}

package com.example.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Diego", "diego@gmail.com", "98988888888", "1234567");
		return ResponseEntity.ok().body(u);		// Return in response with sucess no http e o body retorna o corpo da resposta
	}
	
}
